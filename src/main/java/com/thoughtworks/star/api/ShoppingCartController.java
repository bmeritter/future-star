package com.thoughtworks.star.api;


import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.ShoppingCart;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.ItemService;
import com.thoughtworks.star.service.ShoppingCartService;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ItemService itemService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addToShoppingCart(@RequestParam String username, @RequestBody Item item) {
        Account account = accountService.findOneByUsername(username);

        List<Item> items = new ArrayList<>();
        items.add(item);
        itemService.save(item);

        ShoppingCart shoppingCart = ShoppingCart.builder().account(account).items(items).build();
        shoppingCartService.save(shoppingCart);
    }
}
