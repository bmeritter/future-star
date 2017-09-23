package com.thoughtworks.star.service;

import com.thoughtworks.star.api.AccountCache;
import com.thoughtworks.star.dto.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public String create(Account account) {
        if ("".equals(account.getPassword()) && "".equals(account.getUsername())) {
            return "create failed";
        }
        AccountCache.accounts.put(account.getUsername(), account);
        return "create success";
    }

}
