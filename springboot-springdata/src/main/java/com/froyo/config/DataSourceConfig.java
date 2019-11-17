package com.froyo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author froy
 */
@Configuration
@PropertySource("classpath:/data/jdbc-dev.properties")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    /**
     * https://commons.apache.org/proper/commons-dbcp/configuration.html
     *
     * @return
     */
    //@Bean(destroyMethod = "close")
    @Bean(destroyMethod = "")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        //dataSource.setMaxActive(env.getProperty("dbcp.maxActive", Integer.class));	ésta atributo esta al una version mas antigua de dbcp
        dataSource.setMaxIdle(env.getProperty("dbcp.maxIdle", Integer.class));
        //dataSource.setMaxWait(env.getProperty("dbcp.maxWait", Integer.class));		ésta atributo esta al una version mas antigua de dbcp
        return dataSource;
    }

}
