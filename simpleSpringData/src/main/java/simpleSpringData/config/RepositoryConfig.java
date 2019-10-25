package simpleSpringData.config;

import com.fd.simpleSpringData.repository.RepositoryPackage;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author froy
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfig {
}
