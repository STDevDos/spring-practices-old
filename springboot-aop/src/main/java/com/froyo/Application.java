package com.froyo;

import com.froyo.dao.AccountDAO;
import com.froyo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //call the business method
        theAccountDAO.addAccount();
        membershipDAO.addAccount();

        //close spring context
        context.close();

    }
}
