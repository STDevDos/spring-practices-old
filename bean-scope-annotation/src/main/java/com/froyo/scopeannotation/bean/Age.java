package com.froyo.scopeannotation.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@SessionScope
@Component
public class Age {

    private String age = "24";

    public Age() {
    	log.debug(String.format("Create new Age: %s", this.age));
    }

}