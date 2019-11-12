package com.froyo.spring.repository.impl.h2;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.froyo.spring.repository.h2.CurrencyH2Repository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class CurrencyH2RepositoryImpl implements CurrencyH2Repository {

    @Inject
    @Qualifier("jdbcTemplateH2")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.execute("create table currency (id SERIAL,currency VARCHAR(255) )");
    }

    @Override
    public String saveCurrency() {

        try {
            jdbcTemplate.execute("insert into currency (currency) values ('BTC') ");
            jdbcTemplate.execute("insert into currency (currency) values ('BTC') ");
            return "SUCCESS insert into customerdata";
        } catch (Exception e) {
            log.error("@@@ saveCurrency: ", e);
            return "ERROR insert into saveCurrency";
        }

    }

}
