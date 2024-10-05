package com.example.graphql.repository;

import com.example.graphql.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByOrderNumber(String orderNumber);

}
