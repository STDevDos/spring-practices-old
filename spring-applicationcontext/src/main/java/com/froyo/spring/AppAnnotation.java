package com.froyo.spring;

import com.froyo.beans.AppConfig;
import com.froyo.beans.World;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class AppAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(AppConfig.class);
        appContext.refresh();

        World m = (World) appContext.getBean("mars"); /* name of the bean */
        log.info(m.getGreeting());

        ((ConfigurableApplicationContext) appContext).close();
    }

}
