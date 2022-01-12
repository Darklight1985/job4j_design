package ru.job4j.solid.lsp.market;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface Store {

    public boolean add(Food food);

    public boolean accept(Food food);

    default double calcFresh(Food food) {
        LocalDate now = LocalDate.now();
        return (double) ChronoUnit.DAYS.between(now, food.getCreateDate())
                / ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
    }
}
