package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void whenCollectAddress() {
        List<Address> expected = List.of(
                new Address("NY", "Washington Street", 8, 123),
                new Address("LA", "White Street", 5, 697),
                new Address("FI", "Brabus Street", 4, 75),
                new Address("GA", "Garden Street", 86, 98)
        );
        List<Profile> profOne = List.of(
                new Profile(expected.get(0)),
                new Profile(expected.get(1)),
                new Profile(expected.get(2)),
                new Profile(expected.get(3))
        );
        List<Address> rsl = new Profiles().collect(profOne);

        assertThat(rsl, is(expected));
    }
}