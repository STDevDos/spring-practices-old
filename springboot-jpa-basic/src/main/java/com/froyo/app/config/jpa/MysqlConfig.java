package com.froyo.app.config.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}
