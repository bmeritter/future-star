package com.thoughtworks.star.service;

import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart findShoppingCartByAccount_Id(String accountId);

    void create(Item item);
}
