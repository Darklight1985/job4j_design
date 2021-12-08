package ru.job4j.control;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExamenIO {

    public static ArgsName validate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Not enough arguments entered");
        }
        ArgsName jvm = ArgsName.of(args);
        if (null == (jvm.get("d")) || !new File(jvm.get("d")).isDirectory()
                || null == (jvm.get("t"))
                || null == (jvm.get("n")) || null == (jvm.get("o"))) {
            throw new IllegalArgumentException("Something went wrong, check your arguments!");
        }
        return jvm;
    }

    public static void main(String[] args) {
        ArgsName jvm = validate(args);
        List<Path> list = new ArrayList<>();
        List<Path> fileList = new ArrayList<>();
        File target = new File(jvm.get("o"));

        try {
         target.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            list = Search.search(Paths.get(jvm.get("d")), uslovie(jvm.get("t"), jvm.get("n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path path : list) {
            if (path.toFile().isFile()) {
                fileList.add(path);
            }
        }
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(target))) {
            for (Path path: fileList) {
                buff.write(path.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileList.forEach(System.out::println);
    }

public static Predicate<Path> uslovie(String krit, String poisk) {
        Predicate<Path> func = null;
        switch (krit) {
            case "name":
               func = p -> p.toFile().getName().startsWith(poisk.split("\\.")[0]);
               break;
            case "mask":
                func = p -> p.toFile().getName().endsWith(poisk.split("\\.")[1]);
                break;
            default:
        }
        return func;
}
}
