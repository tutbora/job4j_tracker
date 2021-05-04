package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Collections.singletonList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDepAscending() {
        List<String> expect = Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        List<String> input = Arrays.asList(
                "K2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1/SK2",
                "K1",
                "K2/SK1",
                "K1/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        List<String> result = Departments.sortAsc(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortDepDescending() {
        List<String> expect = Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2"
        );
        List<String> input = Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K1/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        List<String> result = Departments.sortDesc(input);
        assertThat(result, is(expect));
    }
}