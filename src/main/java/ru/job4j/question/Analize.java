package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;

        Map<Integer, String> previousList = previous.stream()
                .collect(Collectors
                        .toMap(User::getId, User::getName, (o1, o2) -> o1, LinkedHashMap::new));

        for (User user : current) {
            if (!previousList.containsKey(user.getId())) {
                added++;
            } else {
                if (!previousList.containsValue(user.getName())
                        && !previousList.remove(user.getId(), user.getName())) {
                    changed++;
                }
            }
        }

        deleted = previousList.size() - current.size() + added;

        return new Info(added, changed, deleted);
    }
}