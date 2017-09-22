package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class AccountController {

    @PostMapping("/api/accounts")
    public String create(@RequestBody Account account) {
        if ("".equals(account.getPassword()) && "".equals(account.getUsername())) {
            return "create failed";
        }
        AccountCache.accounts.put(account.getUsername(), account);
        return "create success";
    }

    @RequestMapping("/api/accounts")
    public Map<String, Account> getAll() {
        return AccountCache.accounts;
    }

}
