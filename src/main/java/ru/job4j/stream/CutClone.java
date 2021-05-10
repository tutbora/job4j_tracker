package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CutClone {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Stepan");
        names.add("Petrucho");
        names.add("Ivan");
        List<String> namesNew = names.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(namesNew);
    }
}