package com.thoughtworks.star.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @RequestMapping("/greeting")
    public String great() {
        return "hello world";
    }
}
