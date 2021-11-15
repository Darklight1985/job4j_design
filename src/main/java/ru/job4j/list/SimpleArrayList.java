package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
        this.size = 0;
        this.modCount = 0;
    }

    @Override
    public void add(T value) {
        modCount++;
        grow();
        this.container[this.size - 1] = value;
    }

    @Override
    public T set(int index, T newValue) {
        modCount++;
        Objects.checkIndex(index, size);
        T rsl = get(index);
        this.container[index] = newValue;
    return rsl;
    }

    @Override
    public T remove(int index) {
        modCount++;
        Objects.checkIndex(index, size);
        T rsl = get(index);
        System.arraycopy(this.container,
                index + 1, this.container,
                index,
                this.container.length - index - 1);
        size--;
        return rsl;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return this.container[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    public void grow() {
        this.size++;
        if (this.size == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }

        };
    }
}