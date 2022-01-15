package ru.job4j.solid.isp.menu;

public class ItemAction implements Action {
    @Override
    public void execute() {
        System.out.println("Что-то делаем");
    }
}
