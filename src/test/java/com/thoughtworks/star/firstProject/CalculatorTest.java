package com.thoughtworks.star.firstProject;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();

    @Test
    public void should_return_all_even_sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(calculator.sumEvens(numbers), is(30));
    }

    @Test
    public void should_return_sorted_map_with_length() {
        List<String> words = Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao", "yibtan", "abc", "sjyuan");

        Map<String, Integer> resultMap = SorterLength.countWordsLengthAsc(words);

        assertThat(resultMap.keySet(), contains("abc", "qiqzhao", "sjyuan", "ybowang", "yibtan", "ynpan", "yzqi"));
        assertThat(resultMap.values(), contains(3, 7, 6, 7, 6, 5, 4));
    }

    @Test
    public void should_return_sorted_string_with_length() {
        String letters = "aababbbcabcdabcde";

        assertThat(SorterLength.sortLettersByCount(letters), is("5(a)<6(b)<3(c)<2(d)<1(e)"));
    }
}
