package com.froyo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author froy
 */
@Configuration
@EnableAspectJAutoProxy /* Spring AOP Proxy Support */
@ComponentScan("com.froyo")
public class DemoConfig {
    //....
}
