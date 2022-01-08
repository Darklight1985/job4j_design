package ru.job4j.solid.srp;

public class Cat implements Animal {
    @Override
    public Animal generate() {
        Animal cat = new Cat();
        return cat;
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }
}
