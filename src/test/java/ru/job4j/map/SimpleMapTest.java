package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMapTest {

    private Map<Integer, String> map;

    @Before
    public void initData() {
        map = new SimpleMap<>();
        map.put(1, "Dima");
        map.put(3, "Gosha");
        map.put(4, "Vova");
        map.put(5, "Lena");
        map.put(6, "Misha");
        map.put(7, "Masha");
        map.put(8, "Toma");
    }

    @Test
    public void whenPutTrue() {
        Assert.assertTrue(map.put(2, "Vasya"));
        Assert.assertEquals("Vasya", map.get(2));
        Assert.assertTrue(map.put(10, "Yura"));
    }

    @Test
    public void whenPutFalse() {
        Assert.assertTrue(map.put(2, "Vasya"));
        Assert.assertFalse(map.put(2, "Kolya"));
    }

    @Test
    public void whenGetNull() {
        Assert.assertTrue(map.put(2, "Vasya"));
        Assert.assertNull(map.get(10));
    }

    @Test
    public void whenRemoveTrue() {
        Assert.assertTrue(map.remove(4));
    }

    @Test
    public void whenRemoveFalse() {
        Assert.assertFalse(map.remove(2));
    }

    @Test
    public void whenGetIteratorFromEmptyMapThenHasNextReturnFalse() {
        map = new SimpleMap<>();
        Assert.assertFalse(map.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyMapThenNextThrowException() {
        map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test
    public void whenGetIteratorTwiceAndNExt() {
        Iterator<Integer> iterator = map.iterator();
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        iterator.next();
        Assert.assertEquals(Integer.valueOf(4), iterator.next());
    }

   @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = map.iterator();
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        map.put(2, "Oshibka");
        iterator.next();
        Assert.assertEquals(Integer.valueOf(4), iterator.next());
    }
}