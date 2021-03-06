package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean rsl = contains(value);
        if (!rsl) {
            set.add(value);
        }
        return !rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T element : set) {
            if (element == value) {
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}