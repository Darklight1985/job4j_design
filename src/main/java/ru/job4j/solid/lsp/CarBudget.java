package ru.job4j.solid.lsp;

public class CarBudget {
    
    private int price;

    public CarBudget(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    public CarBudget generate(int price) {
        CarBudget rsl = null;
     if (price > 5000) {
      rsl = new CarBudget(price);
     }
     return rsl;
    }
}
