package com.froyo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author froy
 * Info: https://lishman.io/spring-data-jpa-configuration
 */
@Configuration
@Import({DataSourceConfig.class, JpaConfig.class, RepositoryConfig.class})
public class Config {
}
