package ru.job4j.examen;

import java.util.*;

/**
 * Метод определяет список уникальных символов в предложении
 */
public class CollectionProTwo {
    public HashSet<Character> unique(String sentense) {
       char[] characters = sentense.toCharArray();
        HashSet<Character> list = new HashSet<>();
        HashSet<Character> nonUniqueList = new HashSet<>();
        for (Character character: characters) {
            if (!list.add(character)) {
                  nonUniqueList.add(character);
            }
        }
        list.removeAll(nonUniqueList);
        return list;
    }

    public static void main(String[] args) {
        CollectionProTwo collectionPro = new CollectionProTwo();
       HashSet<Character> characters = collectionPro.unique("No love, No war");
       characters.forEach(s -> System.out.println(s));
    }

}
