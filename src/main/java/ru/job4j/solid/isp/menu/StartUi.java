package ru.job4j.solid.isp.menu;

import java.util.List;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class StartUi {

    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        List<Item> list = new ArrayList<>();
        MenuItem start = new MenuItem("1. Главное меню");
        MenuItem sunMenuOne = new MenuItem("1.1. Пункт меню");
        MenuItem subMenuTwo = new MenuItem("1.2. Пункт меню");
        MenuItem subMenuThree = new MenuItem("1.3. Пункт меню");
        start.add(sunMenuOne);
        start.add(subMenuTwo);
        start.add(subMenuThree);
        MenuItem exit = new MenuItem("2. Выход");
        list.add(start);
        list.add(exit);

        while (run) {
            ListIterator<Item> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Item item = listIterator.next();
                System.out.println(item.getName());
                if (item.getList().size() > 0) {
                    list.addAll(list.indexOf(item) + 1, item.getList());
                    listIterator = list.listIterator();
                    listIterator.next();
                }
            }
            System.out.println("Выберите пункт меню");
            String select = scanner.nextLine();
            if (select.equals("Выход")) {
                run = false;
            }
        }
    }
}
