package com.froyo.service;

import com.froyo.beans.AppConfig;
import com.froyo.beans.Planet;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class AppAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(AppConfig.class);
        appContext.refresh();

        Planet m = (Planet) appContext.getBean("mars"); /* name of the bean */
        log.info(m.getPlanetTypeEnum().toString());

        ((ConfigurableApplicationContext) appContext).close();
    }

}
