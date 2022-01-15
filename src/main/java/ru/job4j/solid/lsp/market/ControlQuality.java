package ru.job4j.solid.lsp.market;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Food> storeList = list.stream()
                .flatMap(store -> store
                        .getListFood()
                        .stream())
                .collect(Collectors.toList());
        for (Store store: list) {
            store.getListFood().clear();
        }
          for (Food food: storeList) {
              distrib(food);
          }
    }
}
