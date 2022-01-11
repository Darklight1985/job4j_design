package ru.job4j.solid.lsp;

public class LuxCar extends CarBudget {

    public LuxCar(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public CarBudget generate(int price) {
        CarBudget rsl = null;
        if (price > 10000) {
            rsl = new CarBudget(price);
        }
        return rsl;
    }
}
