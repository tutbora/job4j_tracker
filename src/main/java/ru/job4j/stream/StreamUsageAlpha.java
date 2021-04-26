package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsageAlpha {
    public static void main(String[] args) {
        ArrayList<Integer> listNum = new ArrayList<>();
        listNum.add(0, 5);
        listNum.add(1, -15);
        listNum.add(2, 7);
        listNum.add(3, -4);
        listNum.add(4, 9);
        listNum.add(5, 2);

        List<Integer> listPositiveSorted = listNum.stream()
                .filter(num -> (num > 0))
                .collect(Collectors.toList());
        listPositiveSorted.forEach(System.out::println);
    }
}
