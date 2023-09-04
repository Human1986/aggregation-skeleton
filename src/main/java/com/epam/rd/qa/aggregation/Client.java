package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;

public class Client {

    private final Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }


    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal totalIncome = BigDecimal.ZERO;
        for (Deposit deposit : deposits) {
            if (deposit != null) {
                totalIncome = totalIncome.add(deposit.income());
            }
        }

        return totalIncome;
    }

    public BigDecimal maxIncome() {
        BigDecimal maxIncome = BigDecimal.ZERO;
        for (Deposit deposit : deposits) {
            if (deposit != null) {
                BigDecimal income = deposit.income();
                if (income.compareTo(maxIncome) > 0) {
                    maxIncome = income;
                }
            }
        }

        return maxIncome;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number >= 0 && number < deposits.length && deposits[number] != null) {
            return deposits[number].income();
        }
        return new BigDecimal("0.00");
    }
}
