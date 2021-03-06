package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        List<String> data = new ArrayList<>();
        try (var scanner = new Scanner(new FileInputStream(argsName.get("path")))
                .useDelimiter("\n");
        ) {
            while (scanner.hasNext()) {
                data.add(scanner.next());
            }
        }
       List<String> list = Arrays
               .stream(data.get(0).trim().split(argsName.get("delimiter")))
               .collect(Collectors.toList());
        String[] needParameters = argsName.get("filter").split(",");

        StringBuilder stringBuilder = new StringBuilder();
        PrintStream console = System.out;

        if (!"stdout".equals(argsName.get("out"))) {
            PrintStream stream = new PrintStream((new FileOutputStream(argsName.get("out"))));
            System.setOut(stream);
        }
            for (String str: needParameters) {
                stringBuilder.append(str + ";");
            }
           stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder);

        for (int j = 1; j < data.size(); j++) {
            stringBuilder.delete(0, stringBuilder.length());
            String[] value = data.get(j).trim().split(argsName.get("delimiter"));
        for (String str: needParameters) {
            int index = list.indexOf(str);
            if (index == -1) {
                continue;
            }
            stringBuilder.append(value[index] + ";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder);
        }
        System.setOut(console);
        }
}
