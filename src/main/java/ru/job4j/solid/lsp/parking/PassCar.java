package ru.job4j.solid.lsp.parking;

public class PassCar extends Car {
   private String number;
   private int size = 1;

    public PassCar(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }
}
