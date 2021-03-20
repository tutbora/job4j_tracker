package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
            if (left.length() < right.length()) {
                for (int i = 0; i < left.length(); i++) {
                    if (left.charAt(i) != right.charAt(i)) {
                        rsl = 1;
                        break;
                    }
                    if (left.charAt(i) == right.charAt(i)) {
                        rsl = -1;
                    }
                }
            }
            if (left.length() > right.length()) {
                for (int i = 0; i < right.length(); i++) {
                    if (left.charAt(i) != right.charAt(i)) {
                        rsl = -1;
                        break;
                    }
                    if (left.charAt(i) == right.charAt(i)) {
                        rsl = -1;
                    }
                }
            }
            if (left.length() == right.length()) {
                for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    rsl = 1;
                    break;
                }
                if (left.charAt(i) == right.charAt(i)) {
                    rsl = 0;
                }
            }
        }
        return rsl;
    }
}