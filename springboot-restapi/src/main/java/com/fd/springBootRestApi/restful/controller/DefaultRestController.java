package com.fd.springBootRestApi.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DefaultRestController {

    @SuppressWarnings("SameReturnValue")
    @RequestMapping()
    public String home() {
        return "This is a default method for the RestController.";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping("/*")
    public String homeAll() {
        return "homeAll";
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/homePage1")
    public String homePage1() {
        return "homePage1";
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping({
            "/homePage2",
            "/homePage3"
    })
    public String homePageTwoThree() {
        return "homePageTwoThree";
    }

}
