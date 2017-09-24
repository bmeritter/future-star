package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public String create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return AccountCache.accounts.values().stream().collect(Collectors.toList());
    }

    @PutMapping(value = "/{username}")
    public String updateAge(@PathVariable String username, @RequestBody Account account) {
        return accountService.updateAge(username, account);
    }

    @RequestMapping(params = "age")
        public List<Map.Entry<String, Account>> getAccountByAge(@RequestParam int age) {
        return accountService.getAccountByAge(age);
    }

}
