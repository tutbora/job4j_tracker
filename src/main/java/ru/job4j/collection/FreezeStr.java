package ru.job4j.collection;

import java.util.HashSet;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        String[] splitLeft = left.split("");
        String[] splitRight = right.split("");
        HashSet<String> checkSet = new HashSet<>();
        for (int s = 0; s < splitRight.length; s++) {
            for (int ss = 0; ss < splitLeft.length; ss++) {
                if (splitRight[s].equals(splitLeft[ss])) {
                    checkSet.add(splitRight[s]);
                    splitRight[s] = "";
                    splitLeft[ss] = "";
                }
            }
        }
        for (String sss : splitRight) {
            if (!checkSet.contains(sss)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}