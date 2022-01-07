package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T findBy(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
            for (T t: value) {
                if (predicate.test(comparator.compare(rsl, t))) {
                    rsl = t;
                }
            }
            return rsl;
        }

    public <T> T max(List<T> value, Comparator<T> comparator) {
         return findBy(value, comparator, s -> s < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, s -> s > 0);
    }
}