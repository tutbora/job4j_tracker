package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamUsageAlpha {
    public static void main(String[] args) {
        ArrayList<Integer> listNum = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            listNum.add(random.nextInt());
        }
        listNum.forEach(System.out::println);
        System.out.println();
        List<Integer> listPositiveSorted = listNum.stream()
                .filter(num -> (num > 0))
                .collect(Collectors.toList());
        listPositiveSorted.forEach(System.out::println);
    }
}
