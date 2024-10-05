package com.example.graphql.controller;

import com.example.graphql.model.Order;
import com.example.graphql.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/orderNumber/{orderNumber}")
    public ResponseEntity<List<Order>> getByOrderNumber(@PathVariable String orderNumber) {
        List<Order> orders = orderRepository.findByOrderNumber(orderNumber);
        return ResponseEntity.ok(orders);
    }

}
