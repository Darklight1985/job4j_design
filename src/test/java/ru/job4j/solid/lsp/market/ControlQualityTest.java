package ru.job4j.solid.lsp.market;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void distribToShop() {
        Store shop = new Shop();
        Food food  = new Food("Milk", LocalDate.of(2022, 01, 15),
                LocalDate.of(2021, 12, 31), 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(shop);
        double fresh = shop.calcFresh(food);
        assertTrue(shop.accept(food));
    }

    @Test
    public void distribTrash() {
        Store trash = new Trash();
        Food food  = new Food("Milk", LocalDate.of(2022, 01, 10),
                LocalDate.of(2021, 12, 31), 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(trash);
        assertTrue(trash.accept(food));
    }

    @Test
    public void distribWarehouse() {
        Store warehouse = new Warehouse();
        Food food  = new Food("Milk", LocalDate.of(2022, 05, 10),
                LocalDate.of(2021, 12, 31), 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(warehouse);
        assertTrue(warehouse.accept(food));
    }
}