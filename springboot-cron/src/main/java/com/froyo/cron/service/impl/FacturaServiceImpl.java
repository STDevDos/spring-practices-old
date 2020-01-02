package com.froyo.cron.service.impl;

import com.froyo.cron.model.CustomerInfo;
import com.froyo.cron.model.ProductOrder;
import com.froyo.cron.service.FacturaService;
import com.froyo.cron.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("facturaServiceImpl")
public class FacturaServiceImpl implements FacturaService {

    private final MailService mailService;

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
