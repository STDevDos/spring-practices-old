package com.froyo.cron.model;

import lombok.Data;

@Data
public class ProductOrder {

    private String orderId;
    private String productName;
    private String status;
    private CustomerInfo customerInfo;

}
