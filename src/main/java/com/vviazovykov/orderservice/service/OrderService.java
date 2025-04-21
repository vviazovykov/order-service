package com.vviazovykov.orderservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.vviazovykov.orderservice.entity.Order;
import com.vviazovykov.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(Long orderId, Order updatedOrder) {
        return orderRepository.findById(orderId).map(order -> {
            if (order.getCreatedAt().plusMinutes(5).isAfter(LocalDateTime.now())) {
                order.setPilotesQuantity(updatedOrder.getPilotesQuantity());
                return orderRepository.save(order);
            }
            return null;
        });
    }
}
