package com.froyo.springBootRestApi.restcontroller;

import com.froyo.springBootRestApi.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/email")
public class SendEmailRestController {

    private final EmailService emailService;

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/sendEmail")
    private String sendEmail() {
        emailService.sendMail("from@gmail.com", "Hi", "Ho ho ho");
        emailService.sendPreConfiguredMail("<p>Ho ho ho</p>");
        emailService.sendMailWithAttachment("from@gmail.com", "Titulo", "<b>boo</b>", null);

        return "success";
    }

}
