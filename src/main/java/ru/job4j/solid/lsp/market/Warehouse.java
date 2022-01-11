package ru.job4j.solid.lsp.market;

import ru.job4j.list.List;

public class Warehouse implements Store {
   private List<Food> list;

   public void add(Food food) {
       list.add(food);
   }
}
