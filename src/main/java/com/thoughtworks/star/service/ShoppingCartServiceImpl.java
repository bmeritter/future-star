package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.ShoppingCart;
import com.thoughtworks.star.repository.ShoppingCartRepository;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCart.setId(StringUtil.randomUUID());
        shoppingCartRepository.save(shoppingCart);
    }
}
