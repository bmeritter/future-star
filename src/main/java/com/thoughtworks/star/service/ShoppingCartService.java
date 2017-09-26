package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart findShoppingCartByAccount_Id(String accountId);

    void save(String username, Item item);

}
