package ru.job4j.solid.lsp.parking;

public class Car {
   private String number;
   private int size;

    public Car(String number, int size) {
        this.number = number;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }
}
