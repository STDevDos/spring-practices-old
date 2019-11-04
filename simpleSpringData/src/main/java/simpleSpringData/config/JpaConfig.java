package simpleSpringData.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import simpleSpringData.domain.DomainPackage;

/**
 * @author froy
 */
@Configuration
@PropertySource("classpath:/data/hibernate.properties")
public class JpaConfig {

    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabasePlatform(env.getProperty("hibernate.dialect"));
        hibernateJpa.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));    //Solo para que nos muestre las sentencias.
        //hibernateJpa.setDatabase(Database.POSTGRESQL);
        //hibernateJpa.setGenerateDdl(true);												// ? 

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(DomainPackage.class.getPackage().getName());
        emf.setJpaVendorAdapter(hibernateJpa);
        emf.setJpaPropertyMap(Collections.singletonMap("javax.persistence.validation.mode", "none"));
        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txnMgr = new JpaTransactionManager();
        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
        //txnMgr.setDataSource(dataSource);
        return txnMgr;
    }

    //Componente scan de services, video 4/35 minuto 17:55

}
