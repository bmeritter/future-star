package com.thoughtworks.star;

import java.util.*;

public class Cal {
    public int getEvenSum(List<Integer> list) {
        return list.stream().filter(item -> item % 2 == 0).reduce(0, (a, b) -> a + b);
    }

    public Map<String, Integer> sort(List<String> list) {
        Collections.sort(list);
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String str : list) {
            map.put(str, str.length());
        }
        return map;
    }
}
