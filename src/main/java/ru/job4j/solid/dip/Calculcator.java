package ru.job4j.solid.dip;

import java.util.function.BiFunction;

public class Calculcator {

    public Double rashot(int x, int y, BiFunction<Integer, Integer, Double> function) {
        if (x == 0 && y == 0) {
            System.out.println("Error, one of the arguments is 0");
            System.exit(0);
        }
        return function.apply(x, y);
    }

}
