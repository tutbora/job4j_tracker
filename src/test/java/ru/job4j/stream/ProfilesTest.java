package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void whenCollectAddress() {
        List<Address> input = List.of(
                new Address("GA", "Garden Street", 86, 98),
                new Address("NY", "Washington Street", 8, 123),
                new Address("FI", "Brabus Street", 4, 75),
                new Address("LA", "White Street", 5, 697),
                new Address("GA", "Garden Street", 86, 98),
                new Address("FI", "Brabus Street", 4, 75),
                new Address("NY", "Washington Street", 8, 123),
                new Address("GA", "Garden Street", 86, 98),
                new Address("NY", "Washington Street", 8, 123),
                new Address("FI", "Brabus Street", 4, 75)
        );
        List<Profile> profOne = List.of(
                new Profile(input.get(0)),
                new Profile(input.get(1)),
                new Profile(input.get(2)),
                new Profile(input.get(3)),
                new Profile(input.get(4)),
                new Profile(input.get(5)),
                new Profile(input.get(6)),
                new Profile(input.get(7)),
                new Profile(input.get(8)),
                new Profile(input.get(9))
        );
        List<Address> expect = List.of(
                new Address("FI", "Brabus Street", 4, 75),
                new Address("GA", "Garden Street", 86, 98),
                new Address("LA", "White Street", 5, 697),
                new Address("NY", "Washington Street", 8, 123)
        );
        List<Address> rsl = new Profiles().collect(profOne);
        assertThat(rsl, is(expect));
    }
}