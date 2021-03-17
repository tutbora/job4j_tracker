package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority
                = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAWAndPrior() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameAW().thenComparing(new JobSortPrior0to9());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameWAAndPrior() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameWA().thenComparing(new JobSortPrior0to9());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAWAndPrior0to9() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameAW().thenComparing(new JobSortPrior0to9());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("ABB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAWAndPrior9to0() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameAW().thenComparing(new JobSortPrior9to0());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("ABB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAW() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameAW();
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameWA() {
        Comparator<Job> cmpNamePriority
                = new JobSortNameWA();
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPrior0to9() {
        Comparator<Job> cmpNamePriority
                = new JobSortPrior0to9();
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPrior9to0() {
        Comparator<Job> cmpNamePriority
                = new JobSortPrior9to0();
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("BBB", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}