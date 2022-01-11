package ru.job4j.solid.lsp;

public class TaxFromCarBudget {

    public double calcTax(CarBudget car) {
        double tax = 0;
        if (car.getPrice() > 5000) {
          tax = 0.07 * car.getPrice();
        }
return tax;
    }
}
