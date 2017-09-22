package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/api/login")
    public String login(@RequestBody Account account) {
        if ("future_star".equals(account.getUsername()) && "123456".equals(account.getPassword())) {
            return "login success";
        }
        return "login failed";
    }
}
