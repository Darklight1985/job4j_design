package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private Action action;
    private List<MenuItem> list;
    private String name;

    protected MenuItem(String name, Action action) {
        this.name = name;
        this.action = action;
        list = new ArrayList<>();
    }

    public List<MenuItem> getList() {
        return list;
    }

    public String getName() {
       return this.name;
    }

    public Action getAction() {
        return action;
    }
}
