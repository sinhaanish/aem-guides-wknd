package com.adobe.aem.guides.wknd.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
    name = "WKND Login Servlet Configuration",
    description = "Configuration for WKND Login Servlet"
)
public @interface LoginServletConfig {
    
    @AttributeDefinition(
        name = "Login URL",
        description = "The URL for j_security_check endpoint (e.g., https://author-p50155-e1713128.adobeaemcloud.com/j_security_check)"
    )
    String loginUrl() default "";
} 