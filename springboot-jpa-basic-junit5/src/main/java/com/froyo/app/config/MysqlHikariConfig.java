package com.froyo.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "mysql.datasource")
public class MysqlHikariConfig extends HikariConfig {

    @Bean(name = "datasourceMysql")
    public DataSource datasource() {
        return new HikariDataSource(this);
    }

    @Bean(name = "jdbcTemplateMysql")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "namedJdbcTemplateMysql")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
