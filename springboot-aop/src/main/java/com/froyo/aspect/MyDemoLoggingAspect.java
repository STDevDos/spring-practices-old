package com.froyo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author froy
 * https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/7084780?start=0
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging.

    //let's start with an @Before advice.

    @Before("execution(public void com.froyo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println(" ====>> Executing before addAccount() ");
    }

    /**
     * each method to start with add*
     */
    @Before("execution(public void add*())")
    public void beforeAddAdvice() {
        System.out.println(" ====>> Executing before add*() ");
    }

// --Commented out by Inspection START (15/11/2019 03:23 a. m.):
//    /**
//     * Pointcut Expression Examples
//     */
//    @Before("execution(* * processCreditCard*())")
//    public void beforeProcessCreditCard() {
//        System.out.println(" ====>> Executing before processCreditCard() ");
//    }
// --Commented out by Inspection STOP (15/11/2019 03:23 a. m.)

}
