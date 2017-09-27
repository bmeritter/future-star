package com.thoughtworks.star.service;

import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.Order;

import java.util.List;

public interface OrderService {
    void create(List<Item> items);

    List<Order> findAll();
}
