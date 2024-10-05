package com.example.graphql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "orders")
@Data
public class Order {

    @Id
    private String id;
    private String orderNumber;
    private String customerName;
    private String shippingAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Date orderDate;
    private String status;

}
