package ru.job4j.solid.isp.menu;

public class Menu {
   private Action action;

    public boolean add(String parentName, String childName, Action action) {
        this.action = action;
        return true;
    }

   public Action select(String item) {
return action;
   }

    @Override
    public String toString() {
        return "Menu{"
                + "action="
                + action + '}';
    }
}
