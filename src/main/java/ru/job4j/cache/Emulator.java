package ru.job4j.cache;

import java.util.Scanner;

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
            int userAction = Integer.parseInt(scanner.nextLine());
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
                    System.out.println(soderjimoe);
                   break;
                default: run = false;
            }
        }
    }

    public static String getNameFile(Scanner scanner) {
        System.out.println("Укажите имя файла");
        return scanner.nextLine();
    }
}
