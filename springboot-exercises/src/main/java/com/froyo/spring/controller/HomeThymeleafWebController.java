package com.froyo.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeThymeleafWebController {

    @Value("${spring.application.name:Spring Web Exercise}")
    private String appName;

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

}
