package com.froyo.spring.repository.h2.impl;

import com.froyo.spring.repository.h2.JDBCH2Repository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Log4j2
@Repository
public class JDBCH2RepositoryImpl implements JDBCH2Repository {

    @Qualifier("jdbcTemplateH2")
    private final JdbcTemplate jdbcTemplate;

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
