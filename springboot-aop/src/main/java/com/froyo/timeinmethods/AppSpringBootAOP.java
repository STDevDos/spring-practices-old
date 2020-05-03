package com.froyo.timeinmethods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.froyo.timeinmethods"})
@EnableAspectJAutoProxy
public class AppSpringBootAOP {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppSpringBootAOP.class);

        CrudService ps = ctx.getBean(CrudService.class);

        ps.create();
        ps.read();
        ps.update();
        ps.delete();

        try {
            ps.select();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }


    }

}
