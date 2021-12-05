package ru.job4j.serialization.json;

import java.util.Arrays;

public class User {
    private int age;
    private String name;
    private boolean drinks;
    private Car car;
    private String[] hobby;

    public User(int age, String name, boolean drinks, Car car, String[] hobby) {
        this.age = age;
        this.name = name;
        this.drinks = drinks;
        this.car = car;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + ", drinks=" + drinks
                + ", car=" + car
                + ", hobby=" + Arrays.toString(hobby)
                + '}';
    }
}
