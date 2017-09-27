package com.thoughtworks.star.service;

import com.thoughtworks.star.entity.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {

    void create(Account account);

    Account findOneByUsername(String username);

    String updateAge(String username, Account account);

    List<Map.Entry<String, Account>> getAccountByAge(int age);
}
