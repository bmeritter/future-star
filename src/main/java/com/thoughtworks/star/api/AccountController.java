package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/api/accounts/{username}/{age}", method = RequestMethod.PUT)
    public String updateAge(@PathVariable String username, @PathVariable int age) {
        if (age != 0) {
            AccountCache.accounts.get(username).setAge(age);
            return "update age success";
        }
        return "update age failed";
    }

}
