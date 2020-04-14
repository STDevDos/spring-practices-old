package com.froyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Froy
 */
@ServletComponentScan
@SpringBootApplication
public class AppSpringBootServlet {
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootServlet.class, args);
    }
}
