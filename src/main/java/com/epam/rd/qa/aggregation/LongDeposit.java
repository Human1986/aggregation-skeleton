package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {
    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    BigDecimal income() {
        BigDecimal currentAmount = getAmount();
        BigDecimal totalIncome = BigDecimal.ZERO;

        for (int i = 1; i <= getPeriod(); i++) {
            if (i >= 7) {
                BigDecimal monthlyIncome = currentAmount.multiply(new BigDecimal("0.15"));
                totalIncome = totalIncome.add(monthlyIncome);
                currentAmount = currentAmount.add(monthlyIncome);
            }
        }

        return totalIncome.setScale(2, RoundingMode.DOWN);
    }
}
