package ru.job4j.solid.lsp.parking;

public class PassCar extends Car {

    private final int size = 1;
   private String number;

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
