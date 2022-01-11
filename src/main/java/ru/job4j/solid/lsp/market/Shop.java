package ru.job4j.solid.lsp.market;

import ru.job4j.list.List;

public class Shop implements Store {
    private List<Food> list;

    @Override
    public void add(Food food) {
        list.add(food);
    }
}
