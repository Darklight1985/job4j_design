package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> previousList = previous.stream()
                .collect(Collectors
                        .toMap(User::getId, User::getName, (o1, o2) -> o1, LinkedHashMap::new));
        Map<Integer, String> currentList = current.stream()
                .collect(Collectors
                        .toMap(User::getId, User::getName, (o1, o2) -> o1, LinkedHashMap::new));

        previousList.remove(currentList);

        for (Map.Entry<Integer, String> mapCur: currentList.entrySet()) {
            if (previousList.containsKey(mapCur.getKey())
                    && !previousList.containsValue(mapCur.getValue())) {
                changed++;
            }
        }
        for (Map.Entry<Integer, String> mapCur: currentList.entrySet()) {
            if (!previousList.containsKey(mapCur) && !previousList.containsKey(mapCur.getKey())) {
                added++;
            }
        }

        for (Map.Entry<Integer, String> mapPrev: previousList.entrySet()) {
            if (!currentList.containsKey(mapPrev) && !currentList.containsKey(mapPrev.getKey())) {
                deleted++;
            }
        }
        return new Info(added, changed, deleted);
    }
}