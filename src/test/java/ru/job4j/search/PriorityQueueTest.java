package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("41middle", 4));
        queue.put(new Task("2middle", 2));
        queue.put(new Task("6middle", 6));
        queue.put(new Task("42middle", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}