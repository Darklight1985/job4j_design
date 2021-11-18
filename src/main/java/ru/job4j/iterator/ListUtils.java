package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> param = list.listIterator(index);
                param.add(value);
        }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> param = list.listIterator(index + 1);
        param.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
              listIterator.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
                listIterator.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (elements.contains(listIterator.next())) {
                listIterator.remove();
            }
        }
    }

}