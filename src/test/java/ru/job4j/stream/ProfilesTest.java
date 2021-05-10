package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void whenCollectAddress() {
        List<Profile> input = Arrays.asList(
                new Profile(new Address("GA", "Garden Street", 86, 98)),
                new Profile(new Address("NY", "Washington Street", 8, 123)),
                new Profile(new Address("FI", "Brabus Street", 4, 75)),
                new Profile(new Address("LA", "White Street", 5, 697)),
                new Profile(new Address("GA", "Garden Street", 86, 98)),
                new Profile(new Address("FI", "Brabus Street", 4, 75)),
                new Profile(new Address("NY", "Washington Street", 8, 123)),
                new Profile(new Address("GA", "Garden Street", 86, 98)),
                new Profile(new Address("NY", "Washington Street", 8, 123)),
                new Profile(new Address("FI", "Brabus Street", 4, 75))
        );
        List<Address> expect = List.of(
                new Address("FI", "Brabus Street", 4, 75),
                new Address("GA", "Garden Street", 86, 98),
                new Address("LA", "White Street", 5, 697),
                new Address("NY", "Washington Street", 8, 123)
        );
        List<Address> rsl = new Profiles().collect(input);
        assertThat(rsl, is(expect));
    }
}