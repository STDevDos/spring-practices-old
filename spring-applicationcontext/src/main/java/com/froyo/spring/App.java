package com.froyo.spring;

import com.froyo.beans.AppConfig;
import com.froyo.beans.AppConfig2;
import com.froyo.beans.Mundo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //ApplicationContext appContext = new ClassPathXmlApplicationContext("com/tcs/xml/beans.xml");
        //ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class,AppConfig2.class);

        //Create a context, like XML.
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        //Register the
        appContext.register(AppConfig.class);
        appContext.register(AppConfig2.class);
        appContext.refresh();

        Mundo m = (Mundo) appContext.getBean("marte"); /* Nombre del bean */
        System.out.println(m.getSaludo());

        ((ConfigurableApplicationContext) appContext).close();
    }

}
