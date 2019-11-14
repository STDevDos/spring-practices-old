package com.fd.cron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

/**
 * @author Froy
 * http://stackoverflow.com/questions/12743846/unable-to-send-an-email-using-smtp-getting-javax-mail-messagingexception-could
 * https://www.google.com/settings/security/lesssecureapps
 * <p>
 * https://myaccount.google.com/security-checkup?utm_source=google-account&utm_medium=web&continue=https%3A%2F%2Fmyaccount.google.com%2F
 * <p>
 * Permitir el acceso en google.
 * https://www.google.com/settings/security/lesssecureapps
 */
@Configuration
@ComponentScan(basePackages = "com.fd.admin")
public class EmailConfig {

    //Put Other Application configuration here.

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //-------------------------------
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("aspringmvc@gmail.com");
        mailSender.setPassword("respetar123456");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        //-------------------------------

        mailSender.setJavaMailProperties(props);
        return mailSender;
    }

    /*
     * FreeMarker configuration.
     */
    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/META-INF/fmtemplates");
        return bean;
    }

}
