package com.froyo.spring.config.databases;

import com.froyo.spring.config.databases.datasources.DataSourceH2Config;
import com.froyo.spring.config.databases.jpa.JPAH2Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceH2Config.class, JPAH2Config.class})
public class H2Config {
}
