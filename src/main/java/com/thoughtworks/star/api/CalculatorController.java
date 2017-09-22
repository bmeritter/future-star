package com.thoughtworks.star.api;

import com.thoughtworks.star.firstProject.Calculator;
import com.thoughtworks.star.firstProject.Sorter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CalculatorController {
    @RequestMapping("/api/sum")
    public int sumEvens(@RequestParam List<Integer> numbers) {

        return new Calculator().sumEvens(numbers);
    }

    @RequestMapping("/api/count")
    public Map<String, Integer> countWordsLength(@RequestParam List<String> words) {
        return Sorter.countWordsLengthAsc(words);
    }

    @RequestMapping("/api/count-letters")
    public String countLettersLength(@RequestParam String letters) {
        return Sorter.sortLettersByCount(letters);
    }
}
