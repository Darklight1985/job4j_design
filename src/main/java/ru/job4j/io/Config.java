package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
       try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().filter(s -> !s.startsWith("#")).forEach(line -> {
                if (line.split("=").length < 2) {
                    throw new IllegalArgumentException();
                }
                    values.put(line.split("=")[0], line.split("=")[1]);
            });
            for (Map.Entry<String, String> map: values.entrySet()) {
                if (map.getKey().equals("") || map.getValue().equals("")) {
                    throw new IllegalArgumentException();
                }
            }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public String value(String key) {
        String rsl = null;
        if (values.containsKey(key)) {
            rsl = values.get(key);
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}
