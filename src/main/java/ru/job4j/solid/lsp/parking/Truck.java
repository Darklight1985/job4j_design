package ru.job4j.solid.lsp.parking;

public class Truck extends Car {

private String number;
private int size;

    public Truck(String number, int size) {
        this.number = number;
        this.size = size;
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
