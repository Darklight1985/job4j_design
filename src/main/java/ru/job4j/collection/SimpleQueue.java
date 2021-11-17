package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        size--;
        return out.pop();
    }

    public void push(T value) {
          int shyotchik = 0;
        while (shyotchik < size) {
            in.push(out.pop());
            shyotchik++;
        }
        out.push(value);
        while (shyotchik > 0) {
            out.push(in.pop());
            shyotchik--;
        }
        size++;
    }
}