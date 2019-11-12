package com.froyo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootJasyptDatasource {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJasyptDatasource.class, args);
	}

}
