package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    private List<Integer> list;

    @BeforeEach
    private void helper() {
        this.list = Arrays.asList(1,2,4,2,5,0,-5);
    }

    @Test
    public void filter() {

        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true);
        ListFilterer filterer = new ListFilterer(filter);

        Assertions.assertEquals(list, filterer.filter(list));
    }
}
