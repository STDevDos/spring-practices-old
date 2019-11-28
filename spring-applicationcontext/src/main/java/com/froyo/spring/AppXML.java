package com.froyo.spring;

import com.froyo.beans.World;
import lombok.extern.java.Log;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log
public class AppXML {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("com/tcs/xml/beans.xml");

        World m = (World) appContext.getBean("saturn"); /* name of the bean */
        log.info(m.getGreeting());

        appContext.close();
    }

}
