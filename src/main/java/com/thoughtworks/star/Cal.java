package com.thoughtworks.star;

import java.util.List;

public class Cal {
    public int getEvenSum(List<Integer> list) {
        return list.stream().filter(item -> item % 2 == 0).reduce(0, (a, b) -> a + b);
    }
}
