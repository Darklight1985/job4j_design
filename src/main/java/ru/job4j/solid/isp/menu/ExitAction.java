package ru.job4j.solid.isp.menu;

public class ExitAction implements Action {

    @Override
    public void execute() {
        System.exit(0);
    }
}
