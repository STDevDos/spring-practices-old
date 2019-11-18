package com.froyo.rememberme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public String createTable() {
        jdbcTemplate.execute("create table persistent_logins (\r\n" +
                "	username varchar(64) not null, \r\n" +
                "	series varchar(64) primary key, 	\r\n" +
                "	token varchar(64) not null,\r\n" +
                "	last_used timestamp not null\r\n" +
                ")");
        return "home2";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = {"/"})
    public String home() {
        return "home";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = {"/login"})
    public String login() {
        return "login";
    }
}
