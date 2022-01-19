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
        List<MenuItem> data = new LinkedList<>();
        data.addAll(this.root.getList());
        ListIterator<MenuItem> listIterator = data.listIterator();
        while (listIterator.hasNext()) {
            MenuItem item = listIterator.next();
            str.append(item.getName() + "\n");
            if (item.getList().size() > 0) {
                data.addAll(data.indexOf(item) + 1, item.getList());
                listIterator = data.listIterator();
                listIterator.next();
            }
        }
        return str.toString();
    }
}
