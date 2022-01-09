package com.training;

public class MortgageCalculator2022 implements MortgageCalculator {

    private final static byte NUMBER_OF_MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator2022(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    @Override
    public double calculateMortgage() {

        double mortgage = principal
                * ((getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()))
                / ((Math.pow(1 + getMonthlyInterest(), getNumberOfPayments())) - 1));
        return mortgage;
    }

    @Override
    public double calculateBalance(short numberOfPaymentsMade) {

        double balance = principal
                * (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments())
                - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);
        return balance;
    }

    @Override
    public double[] getBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private int getNumberOfPayments() {
        return years * NUMBER_OF_MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
    }
}
