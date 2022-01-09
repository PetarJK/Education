package com.training;

public interface MortgageCalculator {

    double calculateMortgage();
    double calculateBalance(short numberOfPaymentsMade);
    double[] getBalances();
}
