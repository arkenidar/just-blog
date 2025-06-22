package com.example.justblog.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.example.justblog:type=BlogApplication,name=BlogStats")
public class BlogStatsJmxBean implements HealthIndicator {

    private long postCount = 0;
    private String applicationStatus = "Running";

    @ManagedAttribute(description = "Total number of blog posts")
    public long getPostCount() {
        return postCount;
    }

    @ManagedAttribute(description = "Current application status")
    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public Health health() {
        return Health.up()
                .withDetail("postCount", postCount)
                .withDetail("status", applicationStatus)
                .build();
    }
}
