package com.froyo;

import com.froyo.config.MySQLConfig;
import com.froyo.config.PlanetsConfig;
import com.froyo.model.dto.PlanetDTO;
import com.froyo.model.entity.BasuraEntity;
import com.froyo.repository.BasuraRepository;
import com.froyo.service.BasuraService;
import com.froyo.service.impl.BasuraServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Log
public class AppAnnotation {

    public static void main(String[] args) {

        var appContext = new AnnotationConfigApplicationContext();
        appContext.register(PlanetsConfig.class);
        appContext.refresh();

        var m = appContext.getBean("mars", PlanetDTO.class); /* name of the bean */
        log.info(m.getPlanetTypeEnum().toString());

        Map<String,BasuraServiceImpl> basuraService = appContext.getBeansOfType(BasuraServiceImpl.class);
        basuraService.forEach((k,v)->{
            System.out.println(k + " - "+v);
        });

        Map<String,Object> beans = appContext.getBeansWithAnnotation(Service.class);
        beans.forEach((k,v)->{
            System.out.println(k + " - "+v);
        });


        String[] beans2 = appContext.getBeanDefinitionNames();
        for(String bean:beans2){

            System.out.println("Bean name: " + bean);

            Object object = appContext.getBean(bean);
            System.out.println( "Bean object:" + object);
        }

        appContext.close();

//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MySQLConfig.class);
//        BasuraService basuraService1 = (BasuraService) context.getBean("basuraService");
//        Optional<BasuraEntity> optionalBasuraEntity = basuraService1.find(1);
//        log.info(optionalBasuraEntity.toString());


//        String[] beans3 = context.getBeanDefinitionNames();
//        for(String bean:beans3){
//
//            System.out.println("Bean name: " + bean);
//
//            Object object = context.getBean(bean);
//            System.out.println( "Bean object:" + object);
//        }
//
//        context.close();

        ConfigurableApplicationContext applicationContext = SpringApplication.run(AppAnnotation.class,
                args);
        /**
         * Get bean by name
         */
//        BasuraService bean = (BasuraService) applicationContext.getBean("basuraServiceImpl");
//        System.out.println(bean.find(1));

        /**
         * Get bean by type
         */
//        BasuraService bean2 = (BasuraServiceImpl) applicationContext.getBean(BasuraServiceImpl.class);
//        System.out.println(bean2.find(1));

        /**
         * Get bean by name and type
         */
//        BasuraService bean3 = applicationContext.getBean("basuraServiceImpl", BasuraServiceImpl.class);
//        System.out.println(bean3.find(1));

        String[] beans4 = applicationContext.getBeanDefinitionNames();
        for(String bean:beans4){

            System.out.println("Bean name: " + bean);

            Object object = applicationContext.getBean(bean);
            System.out.println( "Bean object:" + object);
        }

        applicationContext.close();

    }

}
