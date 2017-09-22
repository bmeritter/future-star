package com.thoughtworks.star.api;

import com.thoughtworks.star.firstProject.Calculator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {
    @RequestMapping("/api/sum")
    public int sumEvens(@RequestParam List<Integer> numbers) {

        return new Calculator().sumEvens(numbers);
    }
}
