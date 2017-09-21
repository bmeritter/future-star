package com.thoughtworks.star;

import java.util.*;
import java.util.stream.Collectors;

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

    public String count(String str) {
        List<String> list = Arrays.asList(str.split(""));

        Map<String, Integer> map = new HashMap<>();

        list.forEach(item -> {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        });

        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
                .map(item -> item.getValue() + "(" + item.getKey() + ")")
                .collect(Collectors.joining("<"));

    }
}
