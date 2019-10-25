package com.fd.batch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Database class configuration.
 *
 * @author Froy
 */
@Configuration
public class DatabaseConfig {

    @Value("${service.db.user.name}")
    private String dbUserName;

    @Value("${service.db.user.password}")
    private String dbUserPassword;

    @Value("${service.db.jdbc.driver.classname}")
    private String jdbcDriver;

    @Value("${service.db.jdbc.driver.url}")
    private String jdbcURL;

    @Bean(name = "batchDataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Creating datasource.
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource datasource() throws SQLException {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbUserPassword);


        return dataSource;

    }

}
