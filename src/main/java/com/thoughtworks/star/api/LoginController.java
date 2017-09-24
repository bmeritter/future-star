package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.Account;
import com.thoughtworks.star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public String login(@RequestBody Account account) {
        if (loginService.login(account)) {
            return "login success";
        }
        return "login failed";
    }
}
