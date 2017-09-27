package com.thoughtworks.star.service;

import com.thoughtworks.star.entity.Item;

import java.util.Collection;

public interface ItemService {
    void create(Item item);

    Collection<Item> findAll();
}
