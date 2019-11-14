package com.fd.springBootRestApi.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DefaultRestController {
	
	@RequestMapping()
    public String home() {
        return "This is a default method for the RestController.";
    }

	@RequestMapping("/*")
	public String homeAll() {
		return "homeAll";
	}
	
	@GetMapping("/homePage1")
	public String homePage1() {
		return "homePage1";
	}
	
	@RequestMapping({
		"/homePage2",
		"/homePage3"
	})
	public String homePageTwoThree() {
		return "homePageTwoThree";
	}

}
