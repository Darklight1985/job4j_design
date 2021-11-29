package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
       try (BufferedReader in = new BufferedReader(new FileReader(source));
           PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
           String crash = "";
           String work = "";
           while (in.ready()) {
               String str = in.readLine();
               if ("".equals(crash) && (str.contains("400") || str.contains("500"))) {
                   crash = str.split(" ")[1];
               } else {
                   if (!"".equals(crash) && (str.contains("200") || str.contains("300"))) {
                     work = str.split(" ")[1];
                   }
               }
               if (!"".equals(crash) && !"".equals(work)) {
                   out.printf("%s%n", crash + ";" + work + ";");
                   crash = "";
                   work = "";
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
Analizy analizy = new Analizy();
analizy.unavailable("server.log", "target.csv");
    }
}