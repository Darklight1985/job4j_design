package ru.job4j.solid.isp;

public interface CollectionListQueueStack<T> {

    public boolean addLast(T t);

    public boolean addFirst(T t);

    public boolean add(T t, int i);

    public boolean deleteLast(T t);

    public boolean deleteFirst(T t);

    public boolean delete(T t, int i);
}
