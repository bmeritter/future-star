package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountCache {
    public static Map<String, Account> accounts = new HashMap<>();

    public static void clear() {
        accounts.clear();
    }

    public static void add(Account account) {
        accounts.put(account.getUsername(), account);
    }
}
