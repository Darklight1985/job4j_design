package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        List<User> previousList = previous.stream().collect(Collectors.toList());
        List<User> currentList = current.stream().collect(Collectors.toList());
        previousList.remove(currentList);

        Collections.sort(currentList);
        Collections.sort(previousList);
        ListIterator<User> userIteratorCur = currentList.listIterator();
        ListIterator<User> userIteratorPrev = previousList.listIterator();

        while (userIteratorCur.hasNext()) {
            User userCurEl = userIteratorCur.next();
            if (userIteratorPrev.hasNext()) {
                User userPrevEl = userIteratorPrev.next();
                if (userPrevEl != userCurEl && userPrevEl.getId() == userCurEl.getId()) {
                    changed++;
                    userIteratorCur.remove();
                    userIteratorPrev.remove();
                }
            }
        }
        ListIterator<User> userIteratorCurNew = currentList.listIterator();
        ListIterator<User> userIteratorPrevNew = previousList.listIterator();

        while (userIteratorCurNew.hasNext()) {
            User userCurEl = userIteratorCurNew.next();
            if (!previousList.contains(userCurEl)) {
                added++;
            }
        }

        while (userIteratorPrevNew.hasNext()) {
            User userPrevEl = userIteratorPrevNew.next();
            if (!currentList.contains(userPrevEl)) {
               deleted++;
            }
        }
        return new Info(added, changed, deleted);
    }
}