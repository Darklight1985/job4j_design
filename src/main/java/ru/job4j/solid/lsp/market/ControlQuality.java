package ru.job4j.solid.lsp.market;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void resort() {
        List<Food> storeList = new ArrayList<>();
        for (Store store: list) {
            storeList.addAll(store.getListFood());
        }
          for (Food food: storeList) {
              distrib(food);
          }
    }
}
