package ru.job4j.solid.lsp.market;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Класс используется для расчета какая доля срока применения уже прошла
 */
public class Estimator {
    public static double calcFresh(Food food) {
        LocalDate now = LocalDate.now();
        return (double) ChronoUnit.DAYS.between(now, food.getCreateDate())
                / ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
    }
}
