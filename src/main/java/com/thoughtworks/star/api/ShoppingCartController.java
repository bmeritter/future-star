package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.ShoppingCart;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.ShoppingCartService;
import com.thoughtworks.star.util.SessionCache;
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

    @Autowired
    private SessionCache sessionCache;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addToShoppingCart(@RequestBody Item item) {
        shoppingCartService.create(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCart getAll() {
        String currentAccount = sessionCache.fetchCurrentAccount();

        if (currentAccount.equals("")) {
            return null;
        }

        Account account = accountService.findOneByUsername(currentAccount);

        ShoppingCart oneByAccount = shoppingCartService.findShoppingCartByAccount_Id(account.getId());
        return oneByAccount;
    }
}
