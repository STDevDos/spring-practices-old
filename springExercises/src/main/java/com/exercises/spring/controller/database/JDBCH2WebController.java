package com.exercises.spring.controller.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercises.spring.services.JDBCH2Service;

@Controller
@RequestMapping("jdbcH2")
public class JDBCH2WebController {

	@Autowired
    private JDBCH2Service jdbch2Service;

    @ResponseBody
    @PostMapping("saveCustomerData")
    public String saveCustomerData() {
        return jdbch2Service.saveCustomerData();
    }

}
