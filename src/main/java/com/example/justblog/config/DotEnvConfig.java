package com.example.justblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;

@Configuration
public class DotEnvConfig {

    private final Environment environment;

    public DotEnvConfig(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void loadDotEnv() {
        // The spring-dotenv library automatically loads .env files
        // This class exists to ensure proper loading order
        System.out.println("✓ Environment configuration loaded");
        
        // Log some non-sensitive config to verify loading
        String activeProfile = environment.getProperty("spring.profiles.active", "default");
        String serverPort = environment.getProperty("server.port", "8080");
        String dbHost = environment.getProperty("DB_HOST", "localhost");
        
        System.out.println("✓ Active profile: " + activeProfile);
        System.out.println("✓ Server port: " + serverPort);
        System.out.println("✓ Database host: " + dbHost);
    }
}
