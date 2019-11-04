package com.froyo.springBootRestApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig {
	
	@Bean
	public SimpleMailMessage emailTemplate() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("from@gmail.com");
		message.setTo("to@gmail.com");
		message.setSubject("Important email");
		message.setText("<b>FATAL</b> - Application crash. Save your job !!");
		return message;
	}
	
}