package com.froyo.service.config.databases;

import com.froyo.service.config.databases.datasources.DataSourcePostgresConfig;
import com.froyo.service.config.databases.jpa.JPAPostgresConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourcePostgresConfig.class, JPAPostgresConfig.class})
public class PostgresConfig {
}
