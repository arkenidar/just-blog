package com.example.justblog.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.jmx.enabled", havingValue = "true")
public class JmxConfig {
    
    // JMX configuration is now handled by Spring Boot's auto-configuration
    // with the JVM arguments in the launch configuration
    
}
