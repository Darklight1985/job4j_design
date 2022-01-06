package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void findByMax() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(7);
        Comparator<Integer> check = Comparator.naturalOrder();
        assertThat(maxMin.max(list, check), is(10));
    }

    @Test
    public void findByMin() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(7);
        Comparator<Integer> check = Comparator.naturalOrder();
        assertThat(maxMin.min(list, check), is(1));
    }
}