package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountCache {
    public static Map<String, Account> accounts = new HashMap<>();
}
