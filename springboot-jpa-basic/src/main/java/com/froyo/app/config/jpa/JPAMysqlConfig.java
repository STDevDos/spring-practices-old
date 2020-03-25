package com.froyo.app.config.jpa;

import com.froyo.app.model.entity.DomainPackagesJPA;
import com.froyo.app.repository.mysql.RepositoryPackageMysql;
import lombok.AllArgsConstructor;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@AllArgsConstructor
@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryPackageMysql.class)
public class JPAMysqlConfig {

    private final Environment env;
    private final DataSource datasourceMysql;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourceMysql);
        entityManagerFactoryBean.setPackagesToScan(DomainPackagesJPA.class.getPackageName());
        entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("mysql");

        entityManagerFactoryBean.setJpaProperties(this.hibernateProperties());
        //entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("mysql.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("mysql.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.properties.hibernate.ddl-auto"));
        return properties;
    }

    private JpaVendorAdapter vendorAdaptor() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // put all the adapter properties here, such as show sql

        vendorAdapter.setShowSql(env.getProperty("mysql.jpa.show-sql", Boolean.class));
        //show sentences
        vendorAdapter.setDatabasePlatform(env.getProperty("mysql.jpa.properties.hibernate.dialect",String.class));
        vendorAdapter.setGenerateDdl(true);

        return vendorAdapter;
    }

}
