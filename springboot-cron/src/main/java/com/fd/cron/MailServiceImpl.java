package com.fd.cron;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Froy
 */
@Service("mailServiceImpl")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    private static final String FM_MAILTEMPLATE = "fm_mailTemplate.ftl";

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("DEMOAPP Order :: " + order.getOrderId());
                helper.setFrom("aspringmvc@gmail.com");
                helper.setReplyTo("aspringmvc@gmail.com");
                helper.setTo(order.getCustomerInfo().getEmail());

                Map<String, Object> model = new HashMap<String, Object>();
                model.put("order", order);

                String text = geFreeMarkerTemplateContent(model);
                System.out.println("Template content : " + text);

                // use the true flag to indicate you need a multipart message
//            	helper.setText(text, true);
                helper.setText("<b>hola</b>", true);

                //Additionally, let's add a resource as an attachment as well.
                helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));

                System.out.println(order.getCustomerInfo().getEmail());
                System.out.println(helper);

            }
        };
        return preparator;
    }

    public String geFreeMarkerTemplateContent(Map<String, Object> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(FM_MAILTEMPLATE), model));
            return content.toString();
        } catch (Exception e) {
            System.out.println("Exception occured while processing fmtemplate:" + e.getMessage());
        }
        return "";
    }

    @Override
    public void sendEmail(Object object) {
        ProductOrder order = (ProductOrder) object;

        MimeMessagePreparator preparator = getMessagePreparator(order);

        try {
            mailSender.send(preparator);
            System.out.println("Message has been sent.............................");
        } catch (MailException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }


}
