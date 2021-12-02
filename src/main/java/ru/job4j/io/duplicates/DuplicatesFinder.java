package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        duplicatesVisitor.getDuplicates().forEach(s -> {
            System.out.println("Имя файла: " + s.getKey().getName());
            System.out.println("Размер файла: " + s.getKey().getSize() + " байт");
            for (int i = 0; i < s.getValue().size(); i++) {
                System.out.println("Путь к дубликату №" + i + ": " + s.getValue().get(i));
            }
        });
    }
}
