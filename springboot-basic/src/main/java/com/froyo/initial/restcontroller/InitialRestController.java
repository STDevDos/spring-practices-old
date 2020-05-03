package com.froyo.initial.restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class InitialRestController {

    @GetMapping("/initial")
    public String initial() {
        return "com/froyo/initial";
    }

}
