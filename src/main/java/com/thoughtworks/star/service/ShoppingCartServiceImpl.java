package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.ShoppingCart;
import com.thoughtworks.star.repository.ShoppingCartRepository;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ItemService itemService;

    @Override
    public void save(String username, Item item) {
        Account account = accountService.findOneByUsername(username);

        Set<Item> items = new HashSet<>();
        items.add(item);
        itemService.save(item);

        ShoppingCart currentShoppingCart = shoppingCartRepository.findShoppingCartByAccount_Id(account.getId());

        ShoppingCart shoppingCart = ShoppingCart.builder().account(account).items(items).build();
        shoppingCart.setId(StringUtil.randomUUID());
        if (currentShoppingCart == null) {

            shoppingCartRepository.save(shoppingCart);
        } else {
            currentShoppingCart.setItems(items);
            currentShoppingCart.setAccount(account);
        }


    }

    public ShoppingCart findOneByAccount(Account account) {
        return shoppingCartRepository.findOneByAccount(account);
    }
}
