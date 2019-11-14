package com.froyo.spring;

import com.froyo.beans.Mundo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXML {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/tcs/xml/beans.xml");

        Mundo m = (Mundo) appContext.getBean("marte"); /* Nombre del bean */
        System.out.println(m.getSaludo());

        ((ConfigurableApplicationContext) appContext).close();
    }

}
