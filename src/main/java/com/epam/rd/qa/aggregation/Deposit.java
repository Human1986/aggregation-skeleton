package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;

public abstract class Deposit {
    protected final BigDecimal amount;
    protected final int period;

    protected Deposit(BigDecimal  depositAmount, int depositPeriod) {
        if (depositPeriod <= 0) throw new IllegalArgumentException();
        if (depositAmount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException();

        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    abstract BigDecimal income();

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getPeriod() {
        return period;
    }
}

