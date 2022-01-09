package ru.job4j.solid.ocp;

public class Hammer implements Instrument {
    @Override
    public void sound() {
        System.out.println("Тук-тук");
    }
}
