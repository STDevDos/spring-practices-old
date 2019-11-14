package com.fd.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Initial Application
 *
 * @author Froy
 * <p>
 * https://www.mkyong.com/spring-boot/spring-boot-non-web-application-example/
 * CommandLineRunner:In Spring Boot, to create a non-web application, implements CommandLineRunner and override the run method.
 */
@SpringBootApplication
@EnableScheduling
//Cannot determine embedded database driver class for database type NONE
public class SpringCronApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCronApplication.class);

    @Autowired
    private CronProcess cronProcess;

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("SpringCronApplication::main");
        SpringApplication.run(SpringCronApplication.class, args);
    }

    public void run(String... args) {
        LOGGER.info("SpringCronApplication::run");
        cronProcess.process(); /* commented for run spring-batch (BatchCongiguration) */
    }

}
