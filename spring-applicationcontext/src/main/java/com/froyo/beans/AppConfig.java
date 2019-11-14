package com.froyo.beans;

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
     */
    @Bean
    public Mundo tierra() {
        return new Mundo();
    }
}
