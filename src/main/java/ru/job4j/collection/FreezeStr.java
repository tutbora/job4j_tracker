package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        String[] splitLeft = left.split("");
        String[] splitRight = right.split("");
        HashSet<String> checkSet = new HashSet<>(Arrays.asList(splitLeft));
        for (String ss : splitRight) {
            if (!checkSet.contains(ss)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}