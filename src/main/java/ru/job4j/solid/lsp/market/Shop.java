package ru.job4j.solid.lsp.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop implements Store {
    private List<Food> list;

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            list.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
       double freshness = calcFresh(food);
        if (freshness >= 0.25 && freshness < 1) {
            rsl = true;
            if (freshness > 0.75) {
                food.setDiscount(0.5);
            }
            System.out.println("Товар " + food.getName() + " добавлен в Shop");
        }
        return rsl;
    }

    @Override
    public List<Food> getListFood() {
        List<Food> newList = new ArrayList<>(list);
        list.clear();
        return newList;
    }
}
