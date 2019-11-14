package com.froyo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The annotating indicates that this class can be used by JavaConfig as a source of bean definitions.
@Configuration
public class AppConfig {

    //Represent the element <bean> that you can see in beans.xml
    /*
     * <beans>
     *   <bean name="world" class="com.tcs.AppConfig"/>
     * </beans>
     *
     */
    @Bean
    public World earth() {
        return new World();
    }

    @Bean
    public World mars() {
        return new World();
    }
}
