package com.froyo.springprofiles.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@EnableConfigurationProperties(DBConfiguration.class)
public class DBConnectionConfiguration {

    private final DBConfiguration dbConfiguration;

    public DBConnectionConfiguration(DBConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
    }

    @SuppressWarnings("SameReturnValue")
    @Profile("dev")
    @Bean
    public String devDBCcnnection() {
        log.info("DB Connection for Dev");
        log.info(dbConfiguration.getUrl());
        log.info(dbConfiguration.getUserName());
        log.info(dbConfiguration.getPassword());
        log.info(dbConfiguration.getDriverClassName());
        return "DB Connection for Dev";
    }

    @SuppressWarnings("SameReturnValue")
    @Profile("test")
    @Bean
    public String devTestCcnnection() {
        log.info("DB Connection for Test");
        log.info(dbConfiguration.getUrl());
        log.info(dbConfiguration.getUserName());
        log.info(dbConfiguration.getPassword());
        log.info(dbConfiguration.getDriverClassName());
        return "DB Connection for Test";
    }

    @SuppressWarnings("SameReturnValue")
    @Profile("prod")
    @Bean
    public String devProdCcnnection() {
        log.info("DB Connection for Prod");
        log.info(dbConfiguration.getUrl());
        log.info(dbConfiguration.getUserName());
        log.info(dbConfiguration.getPassword());
        log.info(dbConfiguration.getDriverClassName());
        return "DB Connection for Prod";
    }

}
