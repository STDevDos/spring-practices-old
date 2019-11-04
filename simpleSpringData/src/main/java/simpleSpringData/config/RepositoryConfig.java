package simpleSpringData.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import simpleSpringData.repository.RepositoryPackage;

/**
 * @author froy
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfig {
}
