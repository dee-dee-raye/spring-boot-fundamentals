package com.pluralsight.fundamentals.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator {
    private final String message_key = "PeopleService";

    @Override
    public Health health() {
        if (!isRunningServicePeopleService()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private boolean isRunningServicePeopleService() {
        Boolean isRunning = false;
        // Add real logic here to see if people service is running, doesn't exist in this demo so skipping
        return isRunning;
    }
}
