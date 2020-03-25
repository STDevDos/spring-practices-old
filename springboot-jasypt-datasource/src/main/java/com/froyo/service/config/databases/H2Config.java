package com.froyo.service.config.databases;

import com.froyo.config.datasources.DataSourceH2Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceH2Config.class})
public class H2Config {
}
