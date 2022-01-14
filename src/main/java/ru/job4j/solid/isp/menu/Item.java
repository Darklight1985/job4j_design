package ru.job4j.solid.isp.menu;

import java.util.List;

public interface Item {

    public String getName();

    public List<Item> getList();

    public void add(Item item);
}
