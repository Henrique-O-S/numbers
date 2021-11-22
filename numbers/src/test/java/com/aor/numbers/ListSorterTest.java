package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach
    private void helper() {
        this.list = Arrays.asList(3, 2, 6, 1, 4, 5, 7, 3, -3);
        this.expected = Arrays.asList(-3, 1, 2, 3, 3, 4, 5, 6, 7);
    }

    @Test
    public void sort() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_bug_8726() {
        List<Integer> bug_list = Arrays.asList(1, 2, 4, 2);
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(bug_list);

        Assertions.assertEquals(Arrays.asList(1, 2, 2, 4), sorted);
    }
}



