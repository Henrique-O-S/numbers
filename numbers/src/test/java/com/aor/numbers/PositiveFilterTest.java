package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void accepted(){

        Integer number = 1;
        PositiveFilter filter = new PositiveFilter();

        Assertions.assertTrue(filter.accept(number));
    }

    @Test
    public void unaccepted(){

        Integer number = -1;
        Integer zero = 0;
        PositiveFilter filter = new PositiveFilter();

        Assertions.assertFalse(filter.accept(number));
        Assertions.assertFalse(filter.accept(zero));
    }
}
