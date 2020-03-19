package com.froyo.service.config.databases;

import com.froyo.service.config.databases.datasources.DataSourceMysqlConfig;
import com.froyo.service.config.databases.jpa.JPAMysqlConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}
