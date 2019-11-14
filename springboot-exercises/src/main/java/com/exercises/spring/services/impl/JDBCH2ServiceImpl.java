package com.exercises.spring.services.impl;

import com.exercises.spring.repository.h2.JDBCH2Repository;
import com.exercises.spring.services.JDBCH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jdbcH2ServiceImpl")
public class JDBCH2ServiceImpl implements JDBCH2Service {

    @Autowired
    private JDBCH2Repository jdbch2Repository;

    @Override
    public String saveCustomerData() {
        return jdbch2Repository.saveCustomerData();
    }
}
