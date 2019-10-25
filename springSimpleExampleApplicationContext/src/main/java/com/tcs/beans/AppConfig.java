package com.tcs.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The annotating indicates that this clase can be used by JavaConfig as a source of bean definitions.
@Configuration
public class AppConfig {

    //Represent the element <bean> that you can see in beans.xml
    /*
     * <beans>
     *   <bean name="mundo" class="com.tcs.AppConfig"/>
     * </beans>
     *
     * the name of the name it is the name of the name of the function.
     * bound to an object instance type: com.tcs.beans.AppConfig
     *
     */
    @Bean
    public Mundo mundo() {
        return new Mundo();
    }
}
