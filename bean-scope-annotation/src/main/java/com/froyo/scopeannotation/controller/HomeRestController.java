package com.froyo.scopeannotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froyo.scopeannotation.bean.Address;
import com.froyo.scopeannotation.bean.Age;

@RestController
@RequestMapping("/api")
public class HomeRestController {

	@Autowired
	private Age age;

	@Autowired
	private Address address;

	@RequestMapping("/address")
	public String address() {
		String result = address.getAddress(); // US @RequestScope
		address.setAddress("EU");
		return "init Data: " + result + "|-----| modified Data: " + address.getAddress();
	}

	@RequestMapping("/addresscheck")
	public String addresscheck() {
		return "check Data: " + address.getAddress(); // US @RequestScope
	}

	@RequestMapping("/age")
	public String age() {
		String result = age.getAge(); // 24 @SessionScope
		age.setAge("25");
		return "init Data: " + result + "|-----| modified Data: " + age.getAge();
	}

	@RequestMapping("/agecheck")
	public String agecheck() {
		return "check Data: " + age.getAge(); // 24 @RequestScope
	}
}
