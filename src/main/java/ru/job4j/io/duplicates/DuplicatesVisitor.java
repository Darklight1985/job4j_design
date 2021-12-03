package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
   private Map<FileProperty, List<Path>> list = new HashMap<>();
   private List<FileProperty> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty =
                new FileProperty(file.toFile().length(), file.toFile().getName());
                if (list.containsKey(fileProperty)) {
                    List<Path> pathList = list.get(fileProperty);
                    pathList.add(file.toAbsolutePath());
                } else {
                    List<Path> pathList = new ArrayList<>();
                    pathList.add(file.toAbsolutePath());
                    list.put(fileProperty, pathList);
                }
        return super.visitFile(file, attrs);
    }

    public List<Map.Entry<FileProperty, List<Path>>> getDuplicates() {
        List<Map.Entry<FileProperty, List<Path>>> duplicates = new ArrayList<>();
        for (Map.Entry<FileProperty, List<Path>> entry : list.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.add(entry);
            }
        }
        return duplicates;
    }
}