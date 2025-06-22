package com.example.justblog.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", "Just Blog")
               .withDetail("description", "A simple Spring Boot blog application")
               .withDetail("version", "1.0.0")
               .withDetail("java-version", System.getProperty("java.version"))
               .withDetail("encoding", System.getProperty("file.encoding"))
               .withDetail("profiles", System.getProperty("spring.profiles.active"));
    }
}
