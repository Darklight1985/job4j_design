package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) {
            try (ZipOutputStream zip =
                         new ZipOutputStream(
                                 new BufferedOutputStream(new FileOutputStream(target)))) {
                    for (File file : sources) {
                 BufferedInputStream out = new BufferedInputStream(new FileInputStream(file));
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                    byte[] bytes = new byte[1024];
                    int count = out.read(bytes);
                    while (count > 1) {
                        zip.write(bytes, 0, count);
                        count = out.read(bytes);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments entered");
        }
        ArgsName jvm = ArgsName.of(args);
        if (null == (jvm.get("d")) || !new File(jvm.get("d")).isDirectory()
                || null == (jvm.get("e")) || null == (jvm.get("o"))) {
            throw new IllegalArgumentException("Something went wrong, check your arguments!");
        }
       List<Path> list = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        try {
          list = Search.search(Paths.get(jvm.get("d")),
                    p -> p.toFile().getName().endsWith(jvm.get("e")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path path: list) {
            if (path.toFile().isFile()) {
                fileList.add(path.toFile());
            }
        }
        if (fileList.size() > 1) {
            packFiles(fileList, new File(jvm.get("o")));
        } else {
            packSingleFile(fileList.get(0), new File(jvm.get("o")));
        }
    }
}
