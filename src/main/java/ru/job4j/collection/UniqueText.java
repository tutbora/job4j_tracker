package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> checkOrigin = new HashSet<>(Arrays.asList(origin));
            for (String ss : text) {
                if (!checkOrigin.contains(ss)) {
                    rsl = false;
                    break;
                }
            }
        return rsl;
    }
}