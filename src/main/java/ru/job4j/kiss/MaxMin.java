package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T findBy(List<T> value, Comparator<T> comparator, Predicate<T> predicate) {
        T rsl = null;
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
        for (T t: value) {
            if (predicate.test(t)) {
                rsl = t;
            }
            }
            return rsl;
        }

    public <T> T max(List<T> value, Comparator<T> comparator) {
         return findBy(value, comparator, T -> T == value.get(0));
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, T -> T == value.get(value.size() - 1));
    }

    private <T> void swap(List<T> value, int elem1, int elem2) {
        T tmp = value.get(elem1);
        value.set(elem1, value.get(elem2));
        value.set(elem2, tmp);
    }
}