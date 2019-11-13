package com.froyo.springprofiles.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ConfigurationProperties("spring.datasource")
@Data
@EqualsAndHashCode
@ToString
public class DBConfiguration {
    
	private String driverClassName;
    private String url;
    private String userName;
    private String password;
    
}
