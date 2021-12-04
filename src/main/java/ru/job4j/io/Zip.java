package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
            try (ZipOutputStream zip =
                         new ZipOutputStream(
                                 new BufferedOutputStream(
                                         new FileOutputStream(target)))) {
                    for (Path path : sources) {
                        zip.putNextEntry(new ZipEntry(String.valueOf(path.toAbsolutePath())));
                        try (BufferedInputStream out =
                                     new BufferedInputStream(
                                             new FileInputStream(String.valueOf(path)))) {
                            zip.write(out.readAllBytes());
                            }
                        }
                    } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip =
                     new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArgsName validate(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments entered");
        }
        ArgsName jvm = ArgsName.of(args);
        if (null == (jvm.get("d")) || !new File(jvm.get("d")).isDirectory()
                || null == (jvm.get("e")) || null == (jvm.get("o"))) {
            throw new IllegalArgumentException("Something went wrong, check your arguments!");
        }
        return jvm;
    }

    public static void main(String[] args) {
            ArgsName jvm = validate(args);
       List<Path> list = new ArrayList<>();
        List<Path> fileList = new ArrayList<>();
        try {
          list = Search.search(Paths.get(jvm.get("d")),
                    p -> !p.toFile().getName().endsWith(jvm.get("e")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path path: list) {
            if (path.toFile().isFile()) {
                fileList.add(path);
            }
        }
        if (fileList.size() > 1) {
            packFiles(fileList, new File(jvm.get("o")));
        } else {
            packSingleFile(fileList.get(0).toFile(), new File(jvm.get("o")));
        }
    }
}
