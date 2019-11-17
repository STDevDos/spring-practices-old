package com.froyo.config;

import com.froyo.repository.RepositoryPackage;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author froy
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfig {
}
