package ru.job4j.solid.isp.menu;

import java.util.Optional;
import java.util.Scanner;

public class StartUi {

    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        MenuItem start = new MenuItem("Корневое меню", new ItemAction());
        Menu menu = new Menu(start);
        MenuItem sunMenuOne = new MenuItem("1.1. Пункт меню", new ItemAction());
        MenuItem subMenuTwo = new MenuItem("1.2. Пункт меню", new ItemAction());
        MenuItem subMenuThree = new MenuItem("1.3. Пункт меню", new ItemAction());
        menu.add("Корневое меню", "1. Главное меню", new ItemAction());
        menu.add("Корневое меню", "2. Выход", new ExitAction());
        menu.add("1. Главное меню", "1.1. Пункт меню", new ItemAction());
        menu.add("1. Главное меню", "1.2. Пункт меню", new ItemAction());

        System.out.println(menu);

       while (run) {
            System.out.println("Выберите пункт меню");
            String select = scanner.nextLine();
           Optional<MenuItem> optParent = menu.find(select);
           optParent.get().getAction().execute();
        }
    }

}
