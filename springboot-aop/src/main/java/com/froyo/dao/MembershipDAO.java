package com.froyo.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class MembershipDAO {

    public void addAccount() {
        log.info(getClass() + " : DB :: ADDING AN ACCOUNT ");
    }

}
