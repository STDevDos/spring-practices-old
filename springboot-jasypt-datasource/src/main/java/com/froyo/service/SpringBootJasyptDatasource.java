package com.froyo.service;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootJasyptDatasource {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasyptDatasource.class, args);
    }

}