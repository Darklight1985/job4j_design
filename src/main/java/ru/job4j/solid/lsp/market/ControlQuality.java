package ru.job4j.solid.lsp.market;

import java.util.List;

import java.util.Iterator;

public class ControlQuality {
    private List<Store> list;

    public ControlQuality(List list) {
      this.list = list;
    }

    public void distrib(Food food) {
        boolean added = false;
        Iterator<Store> stores = list.iterator();
           while (stores.hasNext() && !added) {
               added = stores.next().add(food);
           }
    }
}
