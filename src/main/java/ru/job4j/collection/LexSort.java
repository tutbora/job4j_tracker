package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftS = left.split(". ");
        String[] rightS = right.split(". ");
        int leftInteger = Integer.parseInt(leftS[0]);
        int rightInteger = Integer.parseInt(rightS[0]);
        /*первый вариант*/
//        if(leftInteger > rightInteger) {
//            return 1;
//        }
//        if(leftInteger == rightInteger) {
//            return 0;
//        }
//        return -1;
        /*второй вариант*/
        return Integer.compare(leftInteger, rightInteger);
    }
}