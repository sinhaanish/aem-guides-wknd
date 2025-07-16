package com.adobe.aem.guides.wknd.core.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.wknd.core.config.LoginServletConfig;
import com.google.gson.JsonObject;

@Component(
    service = Servlet.class,
    property = {
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST,
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/wknd/login",
        "service.description=" + "Login Servlet",
        "service.vendor=" + "WKND"
    }
)
@Designate(ocd = LoginServletConfig.class)
public class LoginServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    private static final long serialVersionUID = 1L;
    
    private String configuredLoginUrl;

    @Activate
    @Modified
    protected void activate(LoginServletConfig config) {
        this.configuredLoginUrl = config.loginUrl();
        log.info("LoginServlet configured with login URL: {}", this.configuredLoginUrl);
    }

    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws IOException {

        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonResponse = new JsonObject();

        // Validate input parameters
        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "Username and password are required");
            jsonResponse.addProperty("errorCode", "MISSING_CREDENTIALS");
            response.getWriter().write(jsonResponse.toString());
            return;
        }

        // Trim whitespace from credentials
        username = username.trim();
        password = password.trim();

        // Use configured login URL or fallback to dynamic construction
        String loginUrl;
        if (configuredLoginUrl != null && !configuredLoginUrl.trim().isEmpty()) {
            loginUrl = configuredLoginUrl;
        } else {
            // Fallback to dynamic construction
            loginUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                      request.getServerPort() + "/j_security_check";
        }

        log.debug("Using login URL: {}", loginUrl);

        HttpPost loginPost = new HttpPost(loginUrl);
        List<BasicNameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("j_username", username));
        formParams.add(new BasicNameValuePair("j_password", password));
        loginPost.setEntity(new UrlEncodedFormEntity(formParams, StandardCharsets.UTF_8));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse loginResponse = httpClient.execute(loginPost, context);

            int statusCode = loginResponse.getStatusLine().getStatusCode();
            
            if (statusCode == 302) {
                // Success - set login-token if available
                List<Cookie> cookies = context.getCookieStore().getCookies();
                for (Cookie cookie : cookies) {
                    if ("login-token".equals(cookie.getName())) {
                        javax.servlet.http.Cookie servletCookie = new javax.servlet.http.Cookie(
                                cookie.getName(), cookie.getValue());
                        servletCookie.setPath("/");
                        servletCookie.setHttpOnly(true);
                        response.addCookie(servletCookie);
                    }
                }

                response.setStatus(HttpServletResponse.SC_OK);
                jsonResponse.addProperty("success", true);
                jsonResponse.addProperty("message", "Login successful");
                jsonResponse.addProperty("username", username);
            } else if (statusCode == 401) {
                // Unauthorized - invalid credentials
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Invalid username or password. Please check your credentials and try again.");
                jsonResponse.addProperty("errorCode", "INVALID_CREDENTIALS");
            } else if (statusCode == 403) {
                // Forbidden - account locked or disabled
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Account is locked or disabled. Please contact your administrator.");
                jsonResponse.addProperty("errorCode", "ACCOUNT_LOCKED");
            } else if (statusCode == 500) {
                // Server error
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Authentication service is temporarily unavailable. Please try again later.");
                jsonResponse.addProperty("errorCode", "AUTH_SERVICE_ERROR");
            } else {
                // Other status codes
                response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
                jsonResponse.addProperty("success", false);
                jsonResponse.addProperty("message", "Authentication failed. Please try again.");
                jsonResponse.addProperty("errorCode", "AUTH_FAILED");
                jsonResponse.addProperty("statusCode", statusCode);
            }
        } catch (java.net.ConnectException e) {
            // Connection error
            log.error("Connection error during login for user: {}", username, e);
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "Authentication service is unavailable. Please try again later.");
            jsonResponse.addProperty("errorCode", "SERVICE_UNAVAILABLE");
        } catch (java.net.SocketTimeoutException e) {
            // Timeout error
            log.error("Timeout error during login for user: {}", username, e);
            response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "Authentication request timed out. Please try again.");
            jsonResponse.addProperty("errorCode", "REQUEST_TIMEOUT");
        } catch (Exception e) {
            // General error
            log.error("Unexpected error during login for user: {}", username, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonResponse.addProperty("success", false);
            jsonResponse.addProperty("message", "An unexpected error occurred. Please try again later.");
            jsonResponse.addProperty("errorCode", "INTERNAL_ERROR");
        }

        response.getWriter().write(jsonResponse.toString());
    }
}