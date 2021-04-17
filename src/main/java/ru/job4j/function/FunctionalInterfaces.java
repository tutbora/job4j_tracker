package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> System.out.println(s + s1);
        List<String> listNumbers = List.of("one", "two", "three", "four", "five", "six", "seven");
        Supplier<Set<String>> sup = () -> new HashSet<>(listNumbers);
        Set<String> strings = sup.get();
        int index = 1;
        for (String s : strings) {
            biCon.accept(index, s);
            map.put(index, s);
            index++;
        }

        BiPredicate<Integer, String> biPred = (s, s1) -> (s % 2 == 0 || s1.length() == 4);
        for (Integer i : map.keySet()) {

            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Consumer<String> con = System.out::println;
        Function<String, String> func = String::toUpperCase;
        for (String s : strings) {

            con.accept(func.apply(s));
        }
    }
}