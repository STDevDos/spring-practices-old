package com.froyo.scopeannotation.bean;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Log4j2
@Data
@RequestScope
@Component
public class Address {

    private String address = "US";

    public Address() {
        log.debug(String.format("Create new Address: %s", this.address));
    }

}
