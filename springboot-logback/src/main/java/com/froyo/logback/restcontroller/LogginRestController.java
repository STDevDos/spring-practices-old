package com.froyo.logback.restcontroller;

import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LogginRestController {

    private final Logger logger = LoggerFactory.getLogger(LogginRestController.class);

    @RequestMapping() // default Mapping
    public String index(@RequestHeader("User-Agent") String userAgent) {

        UserAgent userAgentObject = UserAgent.parseUserAgentString(userAgent);

        //

        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");

        //By default
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        logger.trace("doStuff needed more information - {}", userAgentObject);
        logger.debug("doStuff needed to debug - {}", userAgentObject);
        logger.info("doStuff took input - {}", userAgentObject.getId());
        logger.warn("doStuff needed to warn - {}", userAgentObject.getBrowserVersion());
        logger.error("doStuff encountered an error with value - {}", userAgentObject.getOperatingSystem());

        return "SUCCESS : default mapping";
    }

}
