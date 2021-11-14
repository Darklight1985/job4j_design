package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();
    private int id = 0;

    @Override
    public void add(T model) {
        id++;
          mem.put(String.valueOf(id), model);
    }

    @Override
    public boolean replace(String id, T model) {
        T search = findById(id);
    return mem.replace(id, search, model);
    }

    @Override
    public boolean delete(String id) {
        T search = findById(id);
        if (search.equals(-1)) {
            return false;
        }
        mem.remove(search);
        return true;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}