package com.froyo.service;

import com.froyo.beans.Planet;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class AppXML {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/froyo/xml/beans.xml");

        Planet m = (Planet) appContext.getBean("saturn"); /* name of the bean */
        log.info(m.getPlanetTypeEnum().toString());

        appContext.close();
    }

}
