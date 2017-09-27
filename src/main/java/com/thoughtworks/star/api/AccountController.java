package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Account account) {
        accountService.create(account);
        return account.getUsername();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Account> getAll() {
        return AccountCache.accounts.values();
    }

    @PutMapping(value = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String updateAge(@PathVariable String username, @RequestBody Account account) {
        return accountService.updateAge(username, account);
    }

    @RequestMapping(params = "age")
    @ResponseStatus(HttpStatus.OK)
    public List<Map.Entry<String, Account>> getAccountByAge(@RequestParam int age) {
        return accountService.getAccountByAge(age);
    }

}
