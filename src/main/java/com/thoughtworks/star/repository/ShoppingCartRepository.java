package com.thoughtworks.star.repository;

import com.thoughtworks.star.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
    ShoppingCart findShoppingCartByAccount_Id(String accountId);
}
