package ru.job4j.solid.dip;


import java.util.ArrayList;
import java.util.List;

public class SomeStore implements Store {
    private  List<String> strings = new ArrayList<>();

    public boolean add(String string) {
       return strings.add(string);
    }

    public List<String> give() {
        return strings;
    }
}
