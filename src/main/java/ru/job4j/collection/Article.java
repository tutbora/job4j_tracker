package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] checkOrigin = origin
                .replaceAll("[.,!?:-]", "")
                .split(" ");
        String[] textLine = line.split(" ");
        HashSet<String> checkSet = new HashSet<>(Arrays.asList(checkOrigin));
        for (String ss : textLine) {
            if (!checkSet.contains(ss)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}