package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {

    void save(Account account);
    String updateAge(String username, Account account);
    List<Map.Entry<String, Account>> getAccountByAge(int age);

    Account findOneByUsername(String username);

//    {
//        if ("".equals(account.getPassword()) && "".equals(account.getUsername())) {
//            return "create failed";
//        }
//        AccountCache.accounts.put(account.getUsername(), account);
//        return "create success";
//    }

//    {
//        if (account.getAge() != 0) {
//            AccountCache.accounts.put(username, account);
//            return "update age success";
//        }
//        return "update age failed";
//    }

//    {
//        return AccountCache.accounts.entrySet().stream().filter(item -> item.getValue().getAge() == age)
//                .collect(Collectors.toList());
//    }
}
