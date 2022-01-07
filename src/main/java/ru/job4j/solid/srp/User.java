package ru.job4j.solid.srp;

import ru.job4j.list.List;

public class User {

   private List<User> list;
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

    public void addList(User user) {
        list.add(user);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

}
