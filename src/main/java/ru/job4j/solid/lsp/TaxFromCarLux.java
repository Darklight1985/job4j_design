package ru.job4j.solid.lsp;

public class TaxFromCarLux extends TaxFromCarBudget {

    @Override
    public double calcTax(CarBudget car) {
            return  0.07 * car.getPrice();
    }
}
