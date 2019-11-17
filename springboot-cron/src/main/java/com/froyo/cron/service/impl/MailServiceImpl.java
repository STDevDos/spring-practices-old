package com.froyo.cron.service.impl;

import com.froyo.cron.model.ProductOrder;
import com.froyo.cron.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

@Service("mailServiceImpl")
public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    private static final String FM_MAILTEMPLATE = "fm_mailTemplate.ftl";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("retrieveFreeMarkerConfigurationTemplate")
    private Configuration freemarkerConfiguration;

    @Override
    public void sendEmail(Object object) {
        ProductOrder order = (ProductOrder) object;

        MimeMessagePreparator preparator = retrieveMessagePreparator(order);

        try {
            mailSender.send(preparator);
            LOGGER.info(" @@@ sendEmail() : Successfuly!");
        } catch (MailException ex) {
            LOGGER.error(" @@@ sendEmail() : Exception occured while processing send email: ", ex);
        }
    }

    private MimeMessagePreparator retrieveMessagePreparator(final ProductOrder order) {

        return mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setSubject("DEMOAPP Order :: " + order.getOrderId());
            helper.setFrom("aspringmvc@gmail.com");
            helper.setReplyTo("aspringmvc@gmail.com");
            helper.setTo(order.getCustomerInfo().getEmail());

            Map<String, Object> model = new HashMap<>();
            model.put("order", order);

            String text = retrieveFreeMarkerTemplateContent(model);

            // use the true flag to indicate you need a multipart message
            helper.setText("<b>hola</b>", true);

            //Additionally, let's add a resource as an attachment as well.
            helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));

        };
    }

    private String retrieveFreeMarkerTemplateContent(Map<String, Object> model) {
        StringBuilder content = new StringBuilder();
        try {
            Template templateFTL = freemarkerConfiguration.getTemplate(FM_MAILTEMPLATE);
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(templateFTL, model));
            return content.toString();
        } catch (Exception ex) {
            LOGGER.error(" @@@ retrieveFreeMarkerTemplateContent() : Exception occured while processing fmtemplate: ", ex);
            return StringUtils.EMPTY;
        }
    }




}
