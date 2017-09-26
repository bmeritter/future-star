package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Item;

import java.util.Set;

public interface OrderService {
    void save(Set<Item> items);
}
