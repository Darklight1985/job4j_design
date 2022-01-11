package ru.job4j.solid.lsp.market;

public class ControlQuality {
    private Store warehouse;
    private Store shop;
    private Store trash;

    public ControlQuality(Store warehouse, Store shop, Store trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void valid(Food food) {
        double freshness = Estimator.calcFresh(food);

      if (freshness < 0.25) {
          warehouse.add(food);
      } else {
          if (freshness < 0) {
              trash.add(food);
          } else {
              if (freshness > 0.75) {
                  food.setDiscount(0.5);
              }
              shop.add(food);
          }
      }
    }
}
