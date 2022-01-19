package ru.job4j.temp;

import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                        .map(task -> level + " " + task))
                .forEach(System.out::println);
        System.out.println();
        repeat(123);
        repeat(255);
        repeat(123456789);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void repeat(int num) {
        System.out.println(hash(num));
        System.out.println(binary(num));
    }

    public static int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }
}