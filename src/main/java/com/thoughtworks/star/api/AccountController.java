package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @PostMapping
    public String create(@RequestBody Account account) {
        if ("".equals(account.getPassword()) && "".equals(account.getUsername())) {
            return "create failed";
        }
        AccountCache.accounts.put(account.getUsername(), account);
        return "create success";
    }

    @RequestMapping
    public Map<String, Account> getAll() {
        return AccountCache.accounts;
    }

    @RequestMapping(value = "/{username}/{age}", method = RequestMethod.PUT)
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
