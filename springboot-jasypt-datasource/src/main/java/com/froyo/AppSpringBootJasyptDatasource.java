package com.froyo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class AppSpringBootJasyptDatasource {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootJasyptDatasource.class, args);
    }

}
