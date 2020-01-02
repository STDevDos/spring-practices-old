package com.froyo.springswagger2.controller;

import com.froyo.springswagger2.model.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class SwaggerRestController {

    @PostMapping("/testRestController")
    public String testRestController(@RequestBody Persona persona) {

        log.debug("Persona: {} ", persona);
        log.debug("testRestController.....................");

        return "Success";
    }

}
