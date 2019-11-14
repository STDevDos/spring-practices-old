package com.froy.springFileUpload.restcontroller;

import com.froy.springFileUpload.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanValidationRestController {
	
	@PostMapping("testController")
	private String testController(@RequestBody User user) {
		
		
		
		return "success";
	}

}
