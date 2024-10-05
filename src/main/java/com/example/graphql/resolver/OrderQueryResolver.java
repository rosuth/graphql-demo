package com.example.graphql.resolver;

import com.example.graphql.model.Order;
import com.example.graphql.model.OrderSummary;
import com.example.graphql.repository.OrderRepository; // Adjust based on your package structure
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderQueryResolver implements GraphQLQueryResolver {
    private final OrderRepository orderRepository;

    public OrderQueryResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Resolver for full Order objects
    public List<Order> ordersByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }

    // Resolver for OrderSummary objects
    public List<OrderSummary> orderSummariesByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber).stream()
                .map(order -> {
                    OrderSummary summary = new OrderSummary();
                    summary.setOrderNumber(order.getOrderNumber());
                    summary.setCustomerName(order.getCustomerName());
                    summary.setShippingAddress(order.getShippingAddress());
                    return summary;
                })
                .collect(Collectors.toList());
    }
}
