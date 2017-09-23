package com.thoughtworks.star.service;

import com.thoughtworks.star.dto.Account;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean login(Account account) {
        return ("future_star".equals(account.getUsername()) && "123456".equals(account.getPassword()));
    }

}
