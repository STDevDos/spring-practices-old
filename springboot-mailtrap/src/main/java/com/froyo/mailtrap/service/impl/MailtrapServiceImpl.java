package com.froyo.mailtrap.service.impl;

import com.froyo.mailtrap.config.properties.EmailConfig;
import com.froyo.mailtrap.dto.FeedbackDTO;
import com.froyo.mailtrap.dto.inout.SendFeedbackResponse;
import com.froyo.mailtrap.service.MailtrapService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service("mailtrapServiceImpl")
public class MailtrapServiceImpl implements MailtrapService {

    private final EmailConfig emailConfig;

    @Override
    public SendFeedbackResponse sendFeedback(FeedbackDTO feedbackDTO) {
        SendFeedbackResponse sendFeedbackResponse = new SendFeedbackResponse();

        //Create a mail sender
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost(emailConfig.getHost());
        javaMailSenderImpl.setPort(emailConfig.getPort());
        javaMailSenderImpl.setUsername(emailConfig.getUserName());
        javaMailSenderImpl.setPassword(emailConfig.getPassword());

        //Create an email instance
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedbackDTO.getEmail());
        simpleMailMessage.setTo("57a591e416-d85bfd@inbox.mailtrap.io");
        simpleMailMessage.setSubject(String.format("New feedback from %s ", feedbackDTO.getName()));
        simpleMailMessage.setText(feedbackDTO.getFeedback());

        //Send mail
        javaMailSenderImpl.send(simpleMailMessage);

        return sendFeedbackResponse;
    }

}
