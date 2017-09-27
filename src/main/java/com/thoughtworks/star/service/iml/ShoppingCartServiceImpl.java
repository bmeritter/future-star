package com.thoughtworks.star.service.iml;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.entity.Item;
import com.thoughtworks.star.entity.ShoppingCart;
import com.thoughtworks.star.repository.ShoppingCartRepository;
import com.thoughtworks.star.service.AccountService;
import com.thoughtworks.star.service.ShoppingCartService;
import com.thoughtworks.star.util.SessionCache;
import com.thoughtworks.star.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SessionCache sessionCache;

    @Override
    public ShoppingCart findShoppingCartByAccount_Id(String accountId) {
        return shoppingCartRepository.findShoppingCartByAccount_Id(accountId);
    }

    @Override
    @Transactional
    public void create(Item item) {
        String currentAccount = sessionCache.fetchCurrentAccount();
        Account account = accountService.findOneByUsername(currentAccount);

        Set<Item> items = new HashSet<>();
        items.add(item);

        ShoppingCart currentShoppingCart = shoppingCartRepository.findShoppingCartByAccount_Id(account.getId());

        if (currentShoppingCart == null) {
            ShoppingCart shoppingCart = ShoppingCart.builder().account(account).items(items).build();
            shoppingCart.setId(StringUtil.randomUUID());
            shoppingCartRepository.save(shoppingCart);
        } else {
            currentShoppingCart.setItems(items);
        }

    }
}
