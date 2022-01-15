package ru.job4j.solid.isp.menu;


import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Item {
    private List<Item> list;
    private String name;

    public MenuItem(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    public List<Item> getList() {
        return list;
    }

    @Override
    public String getName() {
       return this.name;
    }

    @Override
    public void add(Item item) {
        list.add(item);
    }
}
