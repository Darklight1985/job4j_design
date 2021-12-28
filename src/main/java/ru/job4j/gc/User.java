package ru.job4j.gc;

public class User {
   private String name;
   private int age;

    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 1000; i++) {
            System.out.println(new User(i, "N" + i));
        }
        GCDemo.info();
    }
}
