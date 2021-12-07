package ru.job4j.serialization.json;

public class Car {
    private String color;
    private int power;

    public Car(String color, int power) {
        this.color = color;
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Car{"
                + "color='" + color + '\''
                + ", power=" + power
                + '}';
    }
}
