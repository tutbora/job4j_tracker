package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public List<Integer> collectToList(Integer[][] matrix) {
        return Arrays
                .stream(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
