package ru.job4j.temp.measure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedOOArray {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);
    }

    public static void measureTime(List<Integer> list) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }

/*
      @replaced
        for (int i = 0; i < 300000; i++) {
            list.get(i);
        }
*/

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
