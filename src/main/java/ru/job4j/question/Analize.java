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
        Collections.sort(currentList);
        Collections.sort(previousList);
       Iterator<User> userIteratorCur = currentList.iterator();
        Iterator<User> userIteratorPrev = previousList.iterator();

      while (userIteratorCur.hasNext()) {
          User userCurEl = userIteratorCur.next();
          if (userCurEl.getId() > 3) {
              added++;
          }
          if (userIteratorPrev.hasNext()) {
              User userPrevEl = userIteratorPrev.next();
              if (userPrevEl != userCurEl)  {
                  if (userPrevEl.getId() == userCurEl.getId()) {
                      changed++;
                  } else {
                      deleted++;
                  }
              }
          }
      }
        return new Info(added, changed, deleted);
    }
}