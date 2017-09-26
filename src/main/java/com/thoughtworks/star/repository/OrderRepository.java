package com.thoughtworks.star.repository;

import com.thoughtworks.star.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
