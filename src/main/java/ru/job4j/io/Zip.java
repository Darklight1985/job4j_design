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
        for (File file: sources) {
            packSingleFile(file, target);
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
        String[] data = {args[0], args[1]};
       Search.validate(data);
        ArgsName jvm = ArgsName.of(args);
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
        packFiles(fileList, new File(jvm.get("o")));
    }
}
