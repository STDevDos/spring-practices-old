package com.exercises.spring.controller.database;

import com.exercises.spring.services.JDBCH2Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("jdbcH2")
public class JDBCH2WebController {

    @Inject
    private JDBCH2Service jdbch2Service;

    @ResponseBody
    @PostMapping("saveCustomerData")
    public String saveCustomerData() {
        return jdbch2Service.saveCustomerData();
    }

}
