package com.thoughtworks.star.firstProject;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter {
    public static Map<String, Integer> countWordsLengthAsc(List<String> words) {
        Collections.sort(words);
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (String str : words) {
            resultMap.put(str, str.length());
        }
        return resultMap;
    }

    static String sortLettersByCount(String letters) {
        Map<String, Integer> countedMap = new HashMap<>();

        Arrays.asList(letters.split("")).forEach(item -> {
            countedMap.put(item, countedMap.containsKey(item) ? countedMap.get(item) + 1 : 1);
        });

        return formatAsString(countedMap);
    }

    private static String formatAsString(Map<String, Integer> countedMap) {
        return countedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(item -> item.getValue() + "(" + item.getKey() + ")")
                .collect(Collectors.joining("<"));
    }
}
