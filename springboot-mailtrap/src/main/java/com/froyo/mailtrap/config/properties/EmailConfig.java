package com.froyo.mailtrap.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties("spring.mail")
public class EmailConfig {

    private String host;
    private int port;
    private String userName;
    private String password;

}
