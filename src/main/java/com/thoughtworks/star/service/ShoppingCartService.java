package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.ShoppingCart;

public interface ShoppingCartService {
    void save(ShoppingCart shoppingCart);

    ShoppingCart findOneByAccount(Account account);
}
