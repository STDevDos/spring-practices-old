package com.froyo.springFileUpload.restcontroller;

import com.froyo.springFileUpload.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class BeanValidationRestController {

    @SuppressWarnings("SameReturnValue")
    @PostMapping("testController")
    private String testController(@RequestBody User user) {

        log.info(user);

        return "success";
    }

}
