package com.froyo.springprofiles.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String userName;
    private String password;

}
