package ru.job4j.temp.set;

import java.util.ArrayList;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        numbers.add(9);
        numbers.add(56);
        numbers.add(25);
        numbers.add(54);
        numbers.sort((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(numbers
        );
    }
}
