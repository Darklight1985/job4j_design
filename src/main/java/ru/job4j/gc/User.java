package ru.job4j.gc;

public class User {
   private String name;
   private int age;

    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 200; i++) {
            System.out.println(new User(i, "N" + i));
        }
        GCDemo.info();
    }
}
