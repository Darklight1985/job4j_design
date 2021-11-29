package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
   private HashSet<FileProperty> list = new HashSet<>();
   private List<FileProperty> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty =
                new FileProperty(file.toFile().length(), file.toFile().getName());
                if (!list.add(fileProperty)) {
                    duplicates.add(fileProperty);
                }
        return super.visitFile(file, attrs);
    }

    public List<FileProperty> getDuplicates() {
        return duplicates;
    }
}