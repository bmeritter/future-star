package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Item;

import java.util.Collection;
import java.util.List;

public interface ItemService {
    void save(Item item);

    Collection<Item> findAll();
}
