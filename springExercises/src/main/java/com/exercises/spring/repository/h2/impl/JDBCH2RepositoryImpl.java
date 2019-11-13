package com.exercises.spring.repository.h2.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exercises.spring.repository.h2.JDBCH2Repository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class JDBCH2RepositoryImpl implements JDBCH2Repository {

    @Autowired
    @Qualifier("jdbcTemplateH2")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.execute("create table customerdata(id SERIAL,name VARCHAR(255),age VARCHAR(255) )");
    }

    @Override
    public String saveCustomerData() {

        try {
            jdbcTemplate.execute("insert into customerdata(id,name,age) values (1,'Froy','34') ");
            return "SUCCESS insert into customerdata";
        } catch (Exception e) {
            log.error("@@@ insertJDBCH2: ", e);
            return "ERROR insert into customerdata";
        }

    }

}
