package com.froyo.mailtrap.restcontroller;

import com.froyo.mailtrap.config.properties.EmailConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MailtrapRestController {

    private final EmailConfig emailConfig;

    @GetMapping("home")
    public String home(){
        log.info(emailConfig.toString());
        return "success";
    }

}
