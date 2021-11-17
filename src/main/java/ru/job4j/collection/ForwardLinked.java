package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = head.next;
        T rsl = temp.value;
        temp.next = null;
          return rsl;
    }

    public void addFirst(T value) {
        head = head != null ? new Node<>(value, head) : new Node<>(value, null);
    }

    public boolean revert() {
        boolean rsl = true;
        Node<T> previous = null;
        Node<T> nowNode = head;
        if (nowNode == null || nowNode.next == null) {
            rsl = false;
        }
          while (nowNode != null) {
              Node<T> nextNode = nowNode.next;
              nowNode.next = previous;
              previous = nowNode;
              nowNode = nextNode;
          }
          head = previous;
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
       private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}
