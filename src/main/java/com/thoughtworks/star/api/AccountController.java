package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public String create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return AccountCache.accounts.values().stream().collect(Collectors.toList());
    }

    @PutMapping(value = "/{username}/{age}")
    public String updateAge(@PathVariable String username, @PathVariable int age) {
        if (age != 0) {
            AccountCache.accounts.get(username).setAge(age);
            return "update age success";
        }
        return "update age failed";
    }

    @RequestMapping(params = "age")
    public List<Map.Entry<String, Account>> getAccountByAge(@RequestParam int age) {
        return AccountCache.accounts.entrySet().stream().filter(item -> item.getValue().getAge() == age)
                .collect(Collectors.toList());
    }

}
