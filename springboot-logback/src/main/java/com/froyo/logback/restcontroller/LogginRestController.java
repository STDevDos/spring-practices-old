package com.froyo.logback.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LogginRestController {

    private final Logger logger = LoggerFactory.getLogger(LogginRestController.class);

    @RequestMapping() // default Mapping
    public String index() {

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "SUCCESS : default mapping";
    }

}
