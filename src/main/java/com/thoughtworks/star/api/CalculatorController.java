package com.thoughtworks.star.api;

import com.thoughtworks.star.firstProject.Calculator;
import com.thoughtworks.star.firstProject.SorterLength;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CalculatorController {
    @RequestMapping("/api/sum")
    @ResponseStatus(HttpStatus.OK)
    public int sumEvens(@RequestParam List<Integer> numbers) {

        return new Calculator().sumEvens(numbers);
    }

    @RequestMapping("/api/count")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Integer> countWordsLength(@RequestParam List<String> words) {
        return SorterLength.countWordsLengthAsc(words);
    }

    @RequestMapping("/api/count-letters")
    @ResponseStatus(HttpStatus.OK)
    public String countLettersLength(@RequestParam String letters) {
        return SorterLength.sortLettersByCount(letters);
    }
}
