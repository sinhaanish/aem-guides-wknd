(function() {
    "use strict";

    async function getCsrfToken() {
        const response = await fetch('/libs/granite/csrf/token.json');
        const json = await response.json();
        return json.token;
    }

    async function handleLogin(event) {
        event.preventDefault();
        
        const form = event.target;
        const errorMessage = form.querySelector('.cmp-login__error-message');
        const submitButton = form.querySelector('.cmp-login__submit-button');
        
        // Get form data
        const formData = new FormData(form);
        
        // Disable button and show loading state
        submitButton.disabled = true;
        submitButton.textContent = 'Logging in...';
        errorMessage.style.display = 'none';
        
        try {
            // Get CSRF token
            const csrfToken = await getCsrfToken();
            
            // Submit the form to our custom login endpoint
            const response = await fetch('/bin/wknd/login', {
                method: 'POST',
                body: formData,
                credentials: 'same-origin',
                headers: {
                    'CSRF-Token': csrfToken
                }
            });
            
            let result;
            try {
                // Try to parse JSON response
                const responseText = await response.text();
                console.log('Response status:', response.status);
                console.log('Response text:', responseText.substring(0, 200)); // Log first 200 chars
                
                if (responseText.trim()) {
                    // Check if response starts with HTML
                    if (responseText.trim().startsWith('<!DOCTYPE') || responseText.trim().startsWith('<html')) {
                        console.error('Server returned HTML instead of JSON');
                        result = { 
                            success: false, 
                            message: 'Server error. Please try again later.' 
                        };
                    } else {
                        result = JSON.parse(responseText);
                    }
                } else {
                    // Empty response
                    result = { success: false, message: 'Empty response from server' };
                }
            } catch (jsonError) {
                console.error('JSON parsing error:', jsonError);
                // If JSON parsing fails, create a basic result object
                result = { 
                    success: false, 
                    message: 'Invalid response from server. Please try again.' 
                };
            }
            
            if (result.success) {
                window.location.reload();
            } else {
                // Handle different error types based on status code
                let displayMessage = result.message || 'Login failed. Please try again.';
                
                switch (response.status) {
                    case 400:
                        displayMessage = 'Please enter both username and password.';
                        break;
                    case 401:
                        displayMessage = 'Invalid username or password. Please check your credentials.';
                        break;
                    case 403:
                        displayMessage = 'Account is locked or disabled. Please contact your administrator.';
                        break;
                    case 404:
                        displayMessage = 'Login service not found. Please contact your administrator.';
                        break;
                    case 408:
                    case 504:
                        displayMessage = 'Request timed out. Please try again.';
                        break;
                    case 503:
                        displayMessage = 'Authentication service is temporarily unavailable. Please try again later.';
                        break;
                    case 500:
                        displayMessage = 'Server error. Please try again later.';
                        break;
                    default:
                        displayMessage = result.message || 'Login failed. Please try again.';
                }
                
                errorMessage.textContent = displayMessage;
                errorMessage.style.display = 'block';
                submitButton.disabled = false;
                submitButton.textContent = 'Login';
            }
        } catch (error) {
            console.error('Login error:', error);
            errorMessage.textContent = 'Network error. Please check your connection and try again.';
            errorMessage.style.display = 'block';
            submitButton.disabled = false;
            submitButton.textContent = 'Login';
        }
    }

    async function handleLogout(event) {
        event.preventDefault();
        
        const form = event.target;
        const logoutButton = form.querySelector('.cmp-login__logout-button');
        
        // Disable button and show loading state
        logoutButton.disabled = true;
        logoutButton.textContent = 'Logging out...';
        
        try {
            // Try POST first (more secure)
            const response = await fetch('/system/sling/logout', {
                method: 'POST',
                credentials: 'same-origin'
            });
            
            if (response.ok) {
                // Redirect to home page or login page after successful logout
                window.location.href = '/';
            } else {
                // If POST fails, try GET
                window.location.href = '/system/sling/logout';
            }
        } catch (error) {
            console.error('Logout error:', error);
            // Fallback to GET method
            window.location.href = '/system/sling/logout';
        }
    }

    // Initialize login and logout forms
    function init() {
        const loginForm = document.querySelector('#loginForm');
        if (loginForm) {
            loginForm.addEventListener('submit', handleLogin);
        }

        const logoutForm = document.querySelector('#logoutForm');
        if (logoutForm) {
            logoutForm.addEventListener('submit', handleLogout);
        }
    }

    // Wait for DOM content to be loaded
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
})(); 