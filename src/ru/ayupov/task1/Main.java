package ru.ayupov.task1;

import java.util.*;

/**
 * public boolean isUnique(Map<String, String> map); *
 * Написать метод, который возвращает true, если в мапе нет двух и более одинаковых value, и false в противном случае. *
 * Для пустой мапы метод возвращает true. *
 * Например, для метода {Вася=Иванов, Петр=Петров, Виктор=Сидоров, Сергей=Савельев, Вадим=Викторов} метод вернет true, *
 * а для {Вася=Иванов, Петр=Петров, Виктор=Иванов, Сергей=Савельев, Вадим=Петров} метод вернет false.
 */

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("Вася", "Иванов");
        map.put("Петр", "Петров");
        map.put("Виктор", "Сидоров");
        map.put("Сергей", "Савельев");
        map.put("Вадим", "Викторов");

        Map<String, String> map2 = new HashMap();
        map2.put("Вася", "Иванов");
        map2.put("Петр", "Петров");
        map2.put("Виктор", "Иванов");
        map2.put("Сергей", "Савельев");
        map2.put("Вадим", "Петров");

        System.out.println(isUnique(map));
        System.out.println(isUnique(map2));

        System.out.println(isUniqueSet(map));
        System.out.println(isUniqueSet(map2));

    }

    public static boolean isUnique(Map<String, String> map) {
        for (String s : map.values()) {
            if (Collections.frequency(map.values(), s) > 1 ) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueSet(Map<String, String> map){
        Collection<String> valuesWithDuplicate = map.values();
        Set<String> nonDuplicateValues = new HashSet<>(valuesWithDuplicate);
        return nonDuplicateValues.size() == map.values().size();

    }

}
