package com.myopd.opd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myopd.opd.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}