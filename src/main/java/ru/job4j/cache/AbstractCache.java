package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (nonNull(value) && !" ".equals(value)) {
            cache.put(key, new SoftReference<>(value));
        }
    }

    public V get(K key) {
        return cache.getOrDefault(key, new SoftReference<>(null)).get();
    }

    protected abstract V load(K key);

}
