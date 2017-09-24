package com.thoughtworks.star.service;

import com.thoughtworks.star.api.AccountCache;
import com.thoughtworks.star.dto.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountService {

    public String create(Account account) {
        if ("".equals(account.getPassword()) && "".equals(account.getUsername())) {
            return "create failed";
        }
        AccountCache.accounts.put(account.getUsername(), account);
        return "create success";
    }

    public String updateAge(String username, Account account) {
        if (account.getAge() != 0) {
            AccountCache.accounts.put(username, account);
            return "update age success";
        }
        return "update age failed";
    }

    public List<Map.Entry<String, Account>> getAccountByAge(int age) {
        return AccountCache.accounts.entrySet().stream().filter(item -> item.getValue().getAge() == age)
                .collect(Collectors.toList());
    }

}
