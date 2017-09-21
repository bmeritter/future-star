package com.thoughtworks.star;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalTest {
    @Test
    public void should_return_all_even_sum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(new Cal().getEvenSum(list), is(30));

    }
}
