package ru.job4j.solid.lsp.market;

import java.util.List;

public class Trash implements Store {
    private List<Food> list;

    public Trash(List<Food> list) {
        this.list = list;
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            list.add(food);
            System.out.println("Товар " + food.getName() + " добавлен в Trash");
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return calcFresh(food) >= 1;
    }
}
