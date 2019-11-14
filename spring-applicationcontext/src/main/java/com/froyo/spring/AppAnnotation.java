package com.froyo.spring;

import com.froyo.beans.AppConfig;
import com.froyo.beans.AppConfig2;
import com.froyo.beans.Mundo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(AppConfig.class);
        appContext.register(AppConfig2.class);
        appContext.refresh();

        Mundo m = (Mundo) appContext.getBean("marte"); /* Nombre del bean */
        System.out.println(m.getSaludo());

        ((ConfigurableApplicationContext) appContext).close();
    }

}
