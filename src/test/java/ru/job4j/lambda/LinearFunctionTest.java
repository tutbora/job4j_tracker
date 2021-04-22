package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinearFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = LinearFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        List<Double> result = LinearFunction.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenExponentialResults() {
        List<Double> result = LinearFunction.diapason(5, 8, x -> Math.pow(6, x));
        List<Double> expected = Arrays.asList(7776D, 46656D, 279936D);
        assertThat(result, is(expected));
    }
}