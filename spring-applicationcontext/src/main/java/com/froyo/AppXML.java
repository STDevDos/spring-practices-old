package com.froyo;

import com.froyo.model.dto.PlanetDTO;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class AppXML {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/froyo/xml/beans.xml");

        PlanetDTO m = (PlanetDTO) appContext.getBean("mercury"); /* name of the bean */
        log.info(m.getPlanetTypeEnum().toString());

        appContext.close();
    }

}
