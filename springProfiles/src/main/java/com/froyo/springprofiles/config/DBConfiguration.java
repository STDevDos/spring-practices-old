package com.froyo.springprofiles.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String userName;
	private String password;

}
