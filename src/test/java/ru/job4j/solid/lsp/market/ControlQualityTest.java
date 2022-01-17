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
        LocalDate createDate = LocalDate.now().minusDays(20);
        LocalDate expiryDate = LocalDate.now().plusDays(4);
        Food food  = new Food("Milk", expiryDate,
                createDate, 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(shop);
        assertTrue(shop.accept(food));
    }

    @Test
    public void distribTrash() {
        Store trash = new Trash();
        LocalDate createDate = LocalDate.now().minusDays(20);
        LocalDate expiryDate = LocalDate.now().minusDays(2);
        Food food  = new Food("Milk", expiryDate,
                createDate, 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(trash);
        assertTrue(trash.accept(food));
    }

    @Test
    public void distribWarehouse() {
        Store warehouse = new Warehouse();
        LocalDate createDate = LocalDate.now().minusDays(20);
        LocalDate expiryDate = LocalDate.now().plusDays(150);
        Food food  = new Food("Milk", expiryDate,
                createDate, 200.0, 0);
        List<Store> list = new ArrayList<>();
        list.add(warehouse);
        assertTrue(warehouse.accept(food));
    }
}