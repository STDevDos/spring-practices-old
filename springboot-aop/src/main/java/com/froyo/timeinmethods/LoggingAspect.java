package com.froyo.timeinmethods;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.froyo.timeinmethods.CrudService.*(..))")
    public void serviceMethod() { }

    @Before("serviceMethod()")
    public void beforeLoginAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.toLongString());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("iniciado " + LocalDateTime.now());
    }

    @After("serviceMethod()")
    public void afterLoginAdvice() {
        System.out.println("finalizado " + LocalDateTime.now());
    }

    @AfterThrowing (pointcut = "execution(* com.froyo.timeinmethods.CrudService.*(..))", throwing = "ex")
    public void afterThrowing(SQLException ex) throws Throwable {
        System.out.println("Ha ocurrido una exception en el servicio CrudService, se ha enviado un email. " + ex);
    }

}
