package com.froyo.spring.controller.database;

import com.froyo.spring.services.JDBCH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
