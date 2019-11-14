package com.fd.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Froy
 */
@Service("facturaServiceImpl")
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private MailService mailService;

    @Override
    public void sendBalance() {

        ProductOrder order = new ProductOrder();
        order.setOrderId("ID123");
        order.setProductName("Thinkpad T510");
        order.setStatus("Confirmed");

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("Carlos Martinez");
        customerInfo.setAddress("WallStreet");
        customerInfo.setEmail("to@gmail.com");
        order.setCustomerInfo(customerInfo);

        mailService.sendEmail(order);

    }

}
