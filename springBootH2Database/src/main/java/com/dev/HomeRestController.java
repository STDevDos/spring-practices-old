package com.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author froy
 */

@RestController
public class HomeRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public void createTable() {
        jdbcTemplate.execute("create table customerdata(id SERIAL,name VARCHAR(255),age VARCHAR(255) )");
    }

    @RequestMapping(value = "/putData", method = RequestMethod.GET)
    public void putData() {
        jdbcTemplate.execute("insert into customerdata(id,name,age) values (1,'Froy','30') ");
    }

    @RequestMapping(value = "/putDataCustom/{id}/{name}/{age}", method = RequestMethod.GET)
    public void putDataCustom(@PathVariable("id") long id, @PathVariable("name") String name, @PathVariable("age") long age) {
        jdbcTemplate.execute("insert into customerdata(id,name,age) values (" + id + ",'" + name + "','" + age + "') ");
    }

}
