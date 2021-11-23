package ru.job4j.examen;

import java.util.*;

public class CollectionPro {
    public List<Character> unique(String sentense) {
       char[] characters = sentense.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character character: characters) {
            list.add(character);
        }
       Set<Character> characterSet = new TreeSet<>();
       for (Character character: characters) {
           characterSet.add(character);
       }
        List<Character> uniqueList = new ArrayList<>();
for (Character character: characterSet) {
           if (Collections.frequency(list, character) < 2) {
               uniqueList.add(character);
           }
}
        return uniqueList;
    }

    public static void main(String[] args) {
        CollectionPro collectionPro = new CollectionPro();
       List<Character> characters = collectionPro.unique("No love, No war");
       characters.forEach(s -> System.out.println(s));
    }

}
