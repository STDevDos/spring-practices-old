package com.froyo.beans;

import com.froyo.beans.common.codevalues.PlanetTypeEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

//The annotating indicates that this class can be used by JavaConfig as a source of bean definitions.
@Configuration
public class AppConfig {

    //Represent the element <bean> that you can see in beans.xml
    /*
     * <beans>
     *   <bean name="world" class="com.froyo.AppConfig"/>
     * </beans>
     *
     */
    @Bean
    public Planet earth() {
        return Planet.builder()
                .planetTypeEnum(PlanetTypeEnum.TIERRA)
                .build();
    }

    @Bean
    public Planet mars() {
        return Planet.builder()
                .planetTypeEnum(PlanetTypeEnum.MARTE)
                .build();
    }
}
