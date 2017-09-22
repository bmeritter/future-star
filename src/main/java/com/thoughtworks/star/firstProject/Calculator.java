package com.thoughtworks.star.firstProject;

import java.util.List;

public class Calculator {
    int sumEvens(List<Integer> numbers) {
        return numbers.stream().filter(item -> item % 2 == 0).reduce(0, (a, b) -> a + b);
    }

}
