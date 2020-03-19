package com.froyo.service.controller.database;

import com.froyo.service.services.JDBCH2Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Controller
@RequestMapping("jdbcH2")
public class JDBCH2WebController {

    private final JDBCH2Service jdbch2Service;

    @ResponseBody
    @PostMapping("saveCustomerData")
    public String saveCustomerData() {
        return jdbch2Service.saveCustomerData();
    }

}
