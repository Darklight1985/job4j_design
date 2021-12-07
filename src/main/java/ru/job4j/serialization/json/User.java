package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int age;
    private String name;
    private boolean drinks;
    private Car car;
    private String[] hobby;

    public User(int age, String name, boolean drinks, Car car, String[] hobby) {
        this.age = age;
        this.name = name;
        this.drinks = drinks;
        this.car = car;
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isDrinks() {
        return drinks;
    }

    public Car getCar() {
        return car;
    }

    public String[] getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + ", drinks=" + drinks
                + ", car=" + car
                + ", hobby=" + Arrays.toString(hobby)
                + '}';
    }

    public static void main(String[] args) {

        JSONObject jsonCar = new JSONObject("{\"color\": \"red\",\"power\": 300}");

        List<String> list = new ArrayList<>();
        list.add("dominoes");
        list.add("women");
        list.add("fight");
        JSONArray jsonHobby = new JSONArray(list);

        final User user = new User(40, "Vasya", true, new Car("red", 300),
                new String[] {"dominoes", "women", "fight"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", user.getAge());
        jsonObject.put("name", user.getName());
        jsonObject.put("drinks", user.isDrinks());
        jsonObject.put("car", jsonCar);
         jsonObject.put("hobby", jsonHobby);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(user).toString());
    }
}
