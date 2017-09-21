package com.thoughtworks.star;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalTest {
    @Test
    public void should_return_all_even_sum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(new Cal().getEvenSum(list), is(30));

    }

    @Test
    public void should_return_sorted_string_with_length() {
        List<String> list = Arrays.asList("ynpan", "yzqi", "ybowang", "qiqzhao", "yibtan", "abc", "sjyuan");

        Map<String, Integer> resultMap = new LinkedHashMap<>();
        resultMap = new Cal().sort(list);

        assertThat(resultMap.keySet(), contains("abc", "qiqzhao", "sjyuan", "ybowang", "yibtan", "ynpan", "yzqi"));
        assertThat(resultMap.values(), contains(3, 7, 6, 7, 6, 5, 4));

    }
}
