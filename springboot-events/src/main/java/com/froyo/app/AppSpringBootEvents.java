package com.froyo.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.springframework.boot.SpringApplication.run;

@EnableAsync
@SpringBootApplication
public class AppSpringBootEvents {

    public static void main(String[] args) {
        run(AppSpringBootEvents.class, args);
    }

}
