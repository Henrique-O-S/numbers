package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    private int number;

    @BeforeEach
    public void helper() {number = 5;}

    @Test
    public void accepted(){

        DivisibleByFilter filter = new DivisibleByFilter(number);

        Assertions.assertTrue(filter.accept(10));
        Assertions.assertTrue(filter.accept(0));
    }

    @Test
    public void unaccepted(){

        DivisibleByFilter filter = new DivisibleByFilter(number);

        Assertions.assertFalse(filter.accept(13));
    }
}
