package com.froyo.cron;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * https://www.mkyong.com/spring-boot/spring-boot-non-web-application-example/
 * CommandLineRunner:In Spring Boot, to create a non-web application, implements CommandLineRunner and override the run method.
 */
@AllArgsConstructor
@SpringBootApplication
@EnableScheduling
public class SpringCronApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCronApplication.class);

    private final CronProcess cronProcess;

    public static void main(String[] args) {
        LOGGER.info("SpringCronApplication::main");
        SpringApplication.run(SpringCronApplication.class, args);
    }

    public void run(String... args) {
        LOGGER.info("SpringCronApplication::run " + args[0]);
        cronProcess.process();
    }

}
