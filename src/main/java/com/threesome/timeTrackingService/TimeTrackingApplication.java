package com.threesome.timeTrackingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.threesome.timeTrackingService.repository")
@EntityScan("com.threesome.timeTrackingService.model")
@ComponentScan("com.threesome.timeTrackingService.*")
public class TimeTrackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeTrackingApplication.class, args);
    }
}