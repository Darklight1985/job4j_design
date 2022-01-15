package ru.job4j.solid.lsp.parking;

public abstract class Car {
   private String number;
   private  int size;

    public String getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }
}
