package com.example.graphql.model;

import lombok.Data;

@Data
public class OrderSummary {
    private String orderNumber;
    private String customerName;
    private String shippingAddress;
}
