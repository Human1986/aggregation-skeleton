package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    BigDecimal income() {
        BigDecimal currentAmount = getAmount();
        BigDecimal totalIncome = BigDecimal.ZERO;

        for (int i = 0; i < getPeriod(); i++) {
            BigDecimal monthlyIncome = currentAmount.multiply(new BigDecimal("0.05"));
            totalIncome = totalIncome.add(monthlyIncome);
            currentAmount = currentAmount.add(monthlyIncome);
        }

        return totalIncome.setScale(2, RoundingMode.DOWN);
    }
}
