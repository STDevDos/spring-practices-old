package com.froyo.spring.config.databases.jpa;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.froyo.spring.model.entity.h2.DomainPackagesH2;
import com.froyo.spring.repository.h2.RepositoryPackageH2;

@EnableJpaRepositories(
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager",
        basePackageClasses = RepositoryPackageH2.class
)
public class JPAH2Config {

    @Inject
    private Environment env;

    @Inject
    private DataSource datasourceH2;

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourceH2);
        entityManagerFactoryBean.setPackagesToScan(DomainPackagesH2.class.getPackageName());
        entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("h2");

        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager h2TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("h2.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("h2.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("h2.jpa.properties.hibernate.ddl-auto"));
        return properties;
    }

    private JpaVendorAdapter vendorAdaptor() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // put all the adapter properties here, such as show sql

        //vendorAdapter.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class)); 	//Solo para que nos muestre las sentencias.
        //vendorAdapter.setDatabasePlatform(env.getProperty("hibernate.dialect"));

        //hibernateJpa.setDatabase(Database.POSTGRESQL);
        //hibernateJpa.setGenerateDdl(true);

        return vendorAdapter;
    }

}
