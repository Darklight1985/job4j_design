package ru.job4j.solid.lsp;

public class Pet {

   private String name;
   private int weght;

    public Pet(String name, int weght) {
        valid(name, weght);
        this.name = name;
        this.weght = weght;
    }

    private void valid(String name, int weght) {
        if ("null".equals(name) || weght > 20) {
            throw new IllegalArgumentException("This is bad data");
        }
    }
}
