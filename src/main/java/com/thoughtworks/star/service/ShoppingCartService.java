package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart findOneByAccount(Account account);

    void save(String username, Item item);

}
