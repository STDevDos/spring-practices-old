package com.froyo;

import com.froyo.model.dto.PlanetDTO;
import com.froyo.model.entity.AnimalsEntity;
import com.froyo.service.AnimalsService;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class AppAnnotation {

    public static void main(String[] args) {

        var appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.froyo"); //scan packages @Bean @Service @Repository
        appContext.refresh();

        var m = appContext.getBean("mars", PlanetDTO.class); /* name of the bean */
        log.info(m.getPlanetTypeEnum().toString());

        AnimalsService animalsService = appContext.getBean(AnimalsService.class);

        /*AnimalsEntity animalsEntity = new AnimalsEntity();
        animalsEntity.setId(1);
        animalsEntity.setName("Avestruz");
        animalsEntity.setDepredador("León,Guepardo");
        animalsEntity.setOrigen("África");
        animalsEntity.setDato_curioso("El ave mas grande del mundo");
        animalsService.addAnimal(animalsEntity);*/

        //animalsService.deleteAnimal(1);

        /*AnimalsEntity animalsEntity = new AnimalsEntity();
        animalsEntity.setId(1);
        animalsEntity.setName("Avestruz");
        animalsEntity.setDepredador("León,Guepardo");
        animalsEntity.setOrigen("África");
        animalsEntity.setDato_curioso("El ave mas grande del mundo");
        animalsService.editAnimal(animalsEntity);*/

        //log.info(animalsService.find(1).toString());
        //log.info(animalsService.findAll().toString());

        //showAllBeans(appContext);

        appContext.close();

    }

    private static void showAllBeans(AnnotationConfigApplicationContext appContext){
        for(String bean:appContext.getBeanDefinitionNames()){
            Object object = appContext.getBean(bean);
            log.info(String.format("Bean name: %s Bean object: %s",bean,object));
        }
    }

}
