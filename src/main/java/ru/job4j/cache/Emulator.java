package ru.job4j.cache;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class Emulator {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        String fileName;
        String uploaded;
        System.out.println("Укажите кэшируемую директорию");
        String dir = scanner.nextLine();
        DirFileCache dirFileCache = new DirFileCache(dir);
        while (run) {
            System.out.println("Выберите необходмое действие");
            System.out.println("1. Загрузить сожержимое файла");
            System.out.println("2. Получить содержимое файла из кэша");
            int userAction = scanner.nextInt();
            switch (userAction) {
                case 1:
                    fileName = getNameFile(scanner);
                    uploaded = dirFileCache.load(fileName);
                    dirFileCache.put(fileName, uploaded);
                    uploaded = null;
                    break;
                case 2:
                    fileName = getNameFile(scanner);
                    String soderjimoe = dirFileCache.get(fileName);
                   if (isNull(soderjimoe)) {
                       uploaded = dirFileCache.load(fileName);
                       dirFileCache.put(fileName, uploaded);
                       soderjimoe = dirFileCache.get(fileName);
                       uploaded = null;
                   }
                    System.out.println(soderjimoe);
                   break;
                default: run = false;
            }
        }
    }

    public static String getNameFile(Scanner scanner) {
        System.out.println("Укажите имя файл");
        return scanner.nextLine();
    }
}
