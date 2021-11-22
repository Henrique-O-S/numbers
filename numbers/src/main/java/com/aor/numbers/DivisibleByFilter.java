package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private int divisor;
    public DivisibleByFilter(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean accept(Integer number) {
        if (number % divisor == 0)
            return true;
        return false;
    }
}
