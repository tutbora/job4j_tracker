package ru.job4j.lambda;

import java.util.Comparator;
import java.util.function.Function;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = Comparator
                .comparing((Function<String, Integer>) s -> {
                    System.out.println("compare " + s.length());
                    return s.length();
                }).reversed();
    }
}
