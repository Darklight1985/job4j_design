package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final User user = new User(40, "Vasya", true, new Car("red", 300),
                new String[] {"dominoes", "women", "fighting"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(user));

       final String userJson =
               "{"
               +  "\"age\": 40,"
               + "\"name\": \"Vasya\","
               + "\"drinks\":true,"
               + "\"car\":"
               + "{"
               + "\"color\": \"red\","
               + "\"power\": 300"
               + "},"
                       + "\"hobby\":"
                       + "[\"dominoes\",\"women\",\"fight\"]"
                       + "}";
        final User userMod = gson.fromJson(userJson, User.class);
        System.out.println(userMod);
    }
}
