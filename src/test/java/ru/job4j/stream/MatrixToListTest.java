package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenMatrixCollectToList() {
        Integer[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> except = List.of(1, 2, 3, 4, 5, 6);
        MatrixToList matrix = new MatrixToList();
        List<Integer> result = matrix.collectToList(input);
        assertThat(result, is(except));
    }
}