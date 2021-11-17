package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFirst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenPushThenPoll() {
        ForwardLinked<Integer> stack = new ForwardLinked<>();
        stack.addFirst(1);
        assertThat(stack.deleteFirst(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        ForwardLinked<Integer> stack = new ForwardLinked<>();
        stack.addFirst(1);
        stack.deleteFirst();
        stack.addFirst(2);
        assertThat(stack.deleteFirst(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        ForwardLinked<Integer> stack = new ForwardLinked<>();
        stack.addFirst(1);
        stack.addFirst(2);
        stack.deleteFirst();
        assertThat(stack.deleteFirst(), is(1));
    }
}