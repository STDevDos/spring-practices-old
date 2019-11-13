package com.exercises.spring.config.databases.jpa;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.exercises.spring.repository.h2.RepositoryPackageH2;

@EnableJpaRepositories(
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager",
        basePackageClasses = RepositoryPackageH2.class
)
public class JPAH2Config {

	@Autowired
    private Environment env;

	@Autowired
    private DataSource datasourceH2;

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourceH2);
        entityManagerFactoryBean.setPackagesToScan("com.exercises.spring.model.h2");
        entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("h2");

        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager postgresTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("h2.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("h2.jpa.properties.hibernate.dialect"));
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
