package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public List<Integer> collectToList(Integer[][] matrix) {

//       first variant
//        List<Integer> rsl = new ArrayList<>();
//        Arrays.stream(matrix)
//         .map(Arrays::asList)
//         .forEach(rsl::addAll);
//        return rsl;

//        second variant
        return Arrays
                .stream(matrix)
                .map(Arrays::asList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
