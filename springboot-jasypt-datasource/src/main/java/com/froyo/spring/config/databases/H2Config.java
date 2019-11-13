package com.froyo.spring.config.databases;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.froyo.spring.config.databases.datasources.DataSourceH2Config;

@Configuration
@Import({DataSourceH2Config.class})
public class H2Config {
}
