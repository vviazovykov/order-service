package com.vviazovykov.orderservice.repository;

import com.vviazovykov.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
