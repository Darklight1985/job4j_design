package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T findBy(List<T> value, Comparator<T> comparator) {
        boolean needIter = true;
        while (needIter) {
            needIter = false;
            for (int i = 1; i < value.size(); i++) {
                if (comparator.compare(value.get(i), value.get(i - 1)) > 0) {
                    swap(value, i, i - 1);
                    needIter = true;
                }
            }
        }
       return value.get(0);
    }

    private <T> void swap(List<T> value, int elem1, int elem2) {
        T tmp = value.get(elem1);
        value.set(elem1, value.get(elem2));
        value.set(elem2, tmp);
    }
}