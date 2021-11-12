package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int index = this.index;
        while (true) {
            if (index >= data.length) {
                return false;
            }
            if (data[index] % 2 == 0) {
                return (index < data.length);
            } else {
                index++;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (true) {
            if (data[index] % 2 == 0) {
                return (data[index++]);
            } else {
                index++;
            }
        }
    }
}