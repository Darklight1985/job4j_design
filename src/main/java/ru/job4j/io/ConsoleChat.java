package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean work = true;
        List<String> conversations = new ArrayList<>();
        List<String> answers = readPhrases();
        Scanner scanner = new Scanner(System.in);
        String userPhrase = null;
        String botPhrase = null;
        while (!OUT.equals(userPhrase)) {
            userPhrase = scanner.nextLine();
            conversations.add(userPhrase);
            switch (userPhrase) {
                case STOP:
                    work = false;
                    break;
                case OUT:
                    break;
                case CONTINUE:
                    work = true;
                default:
                    if (work) {
                        botPhrase = answers.get((int) (Math.random() * 3));
                        System.out.println(botPhrase);
                        conversations.add(botPhrase);
                    }
            }
        }
        saveLog(conversations);
    }

    private List<String> readPhrases() {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(sentences::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"),
                true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/conversation.log", "./data/phrase.txt");
        cc.run();
    }
}
