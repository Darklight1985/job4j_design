package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (nonNull(value) && !" ".equals(value)) {
            cache.put(key, new SoftReference<>(value));
        } else {
            throw new IllegalArgumentException("There is no data in the file");
        }
    }

    public V get(K key) {
        V rsl = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (isNull(rsl)) {
            rsl = load(key);
            cache.put(key, new SoftReference<>(load(key)));
        }
        return rsl;
    }

    protected abstract V load(K key);

}
