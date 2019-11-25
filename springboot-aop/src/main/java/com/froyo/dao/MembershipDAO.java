package com.froyo.dao;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " : DB :: ADDING AN ACCOUNT ");
    }

}
