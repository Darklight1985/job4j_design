package ru.job4j.solid.dip;

public class Manipulator {

    public void transfer(SomeStore storeOne, SomeStore storeTwo) {
       storeTwo.give().clear();
       for (String strings: storeOne.give()) {
           storeTwo.add(strings);
       }
    }
}
