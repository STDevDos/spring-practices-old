package com.froyo.spring.config.databases;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.froyo.spring.config.databases.datasources.DataSourceMysqlConfig;
import com.froyo.spring.config.databases.jpa.JPAMysqlConfig;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}
