package com.froyo.config;

import com.froyo.common.codevalues.PlanetTypeEnum;
import com.froyo.model.dto.PlanetDTO;
import com.froyo.service.BasuraService;
import com.froyo.service.impl.BasuraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The annotating indicates that this class can be used by JavaConfig as a source of bean definitions.
@Configuration
public class PlanetsConfig {

    //Represent the element <bean> that you can see in beans.xml
    /*
     * <beans>
     *   <bean name="world" class="com.froyo.AppConfig"/>
     * </beans>
     *
     */
    @Bean
    public PlanetDTO earth() {
        return PlanetDTO.builder()
                .planetTypeEnum(PlanetTypeEnum.EARTH)
                .build();
    }

    @Bean
    public PlanetDTO mars() {

        return PlanetDTO.builder()
                .planetTypeEnum(PlanetTypeEnum.MARS)
                .build();
    }
}
