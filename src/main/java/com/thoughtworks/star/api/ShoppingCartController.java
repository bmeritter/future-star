package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.dto.Item;
import com.thoughtworks.star.dto.ShoppingCart;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addToShoppingCart(@RequestBody Item item) {

        shoppingCartService.save(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCart getAll(@RequestParam String username) {
        Account account = accountService.findOneByUsername(username);

        ShoppingCart oneByAccount = shoppingCartService.findShoppingCartByAccount_Id(account.getId());
        return oneByAccount;

    }
}
