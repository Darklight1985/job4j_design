package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
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
               .stream(data.get(0).split(argsName.get("delimiter")))
               .collect(Collectors.toList());
        String[] needParameters = argsName.get("filter").split(",");

        File target = new File(argsName.get("out"));
        StringBuilder stringBuilder = new StringBuilder();
        try (PrintWriter out = new PrintWriter(target)) {
            for (String str: needParameters) {
                stringBuilder.append(str + ";");
            }
           stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            out.println(stringBuilder);

        for (int j = 1; j < data.size(); j++) {
            stringBuilder.delete(0, stringBuilder.length());
            String[] value = data.get(j).split(argsName.get("delimiter"));
        for (int i = 0; i < needParameters.length; i++) {
            int index = list.indexOf(needParameters[i]);
            stringBuilder.append(value[index] + ";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            out.println(stringBuilder);
        }
        }
    }
}
