package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        modCount++;
        boolean rsl = false;
        int numberCell = indexFor(hash(key.hashCode()));
        if (table[numberCell] == null || count == 0) {
            table[numberCell] = new MapEntry<>(key, value);
            count++;
            expand();
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
     if (count / LOAD_FACTOR >= capacity) {
      MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
      int numberCell = 0;
            for (MapEntry<K, V> mapEntry: table) {
                if (mapEntry != null) {
                     numberCell = indexFor(hash(mapEntry.key.hashCode()));
                    newTable[numberCell] = table[numberCell];
                }
            }
            capacity = capacity * 2;
            table = newTable;
     }
    }

    @Override
    public V get(K key) {
        V rsl = null;
        for (MapEntry<K, V> mapEntry: table) {
            if (mapEntry != null) {
                if (mapEntry.key == key) {
                    rsl = table[indexFor(hash(key.hashCode()))].value;
                }
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        modCount++;
        V check = get(key);
        boolean rsl = false;
        if (check != null) {
            rsl = true;
            table[indexFor(hash(key.hashCode()))].value = null;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private K rsl;
            private int shyotchik = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (table[shyotchik] == null && shyotchik < count) {
                    shyotchik++;
                }
                return shyotchik < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[shyotchik++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

       private K key;
       private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}