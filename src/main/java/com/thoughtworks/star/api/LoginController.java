package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.Account;
import com.thoughtworks.star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody Account account) {
        if (loginService.login(account)) {
            return "login success";
        }
        return "login failed";
    }
}
