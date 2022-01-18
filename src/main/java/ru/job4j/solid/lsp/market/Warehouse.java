package ru.job4j.solid.lsp.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Warehouse implements Store {
   private List<Food> list;

    @Override
   public boolean add(Food food) {
      boolean rsl = accept(food);
       if (rsl) {
           list.add(food);
           System.out.println("Товар " + food.getName() + " добавлен в Warehouse");
       }
       return rsl;
   }

    @Override
    public boolean accept(Food food) {
       return calcFresh(food) < 0.25;
    }

    @Override
    public List<Food> getListFood() {
        List<Food> newList = new ArrayList<>(list);
        list.clear();
       return newList;
    }
}
