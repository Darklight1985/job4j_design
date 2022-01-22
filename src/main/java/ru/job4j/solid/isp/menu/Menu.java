package ru.job4j.solid.isp.menu;

import java.util.*;

public class Menu {
    private final MenuItem root;

    public Menu(MenuItem root) {
        this.root = root;
    }

    public boolean add(String parent, String child, Action action) {
        boolean rsl = false;
        Optional<MenuItem> optParent = find(parent);
        if (optParent.isPresent()) {
            MenuItem father = optParent.get();
            father.getList().add(new MenuItem(child, action));
            rsl = true;
        }
        return rsl;
    }

    public Optional<MenuItem> find(String key) {
        Optional<MenuItem> found = Optional.empty();
        Queue<MenuItem> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            MenuItem item = data.poll();
            if (item.getName().equals(key)) {
                found = Optional.of(item);
                break;
            }
            data.addAll(item.getList());
        }
        return found;
    }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
           Stack<MenuItem> stack = new Stack();
            MenuItem current;
            if (root.getList().size() > 0) {
                for (MenuItem item : root.getList()) {
                    stack.push(item);
                }
            }
            while (!stack.isEmpty()) {
                 current = stack.pop();
                str.append(current.getName() + System.lineSeparator());
                if (current.getList().size() > 0) {
                    for (MenuItem item: current.getList()) {
                    stack.push(item); }
                }
                }
            return str.toString();
            }
}
