package com.training;

public class MortgageCalculator2022 {

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

    public double calculateBalance(short numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
        int numberOfPayments = years * NUMBER_OF_MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public double calculateMortgage() {

        float monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
        int numberOfPayments = years * NUMBER_OF_MONTHS_IN_YEAR;

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1));
        return mortgage;
    }

    public int getNumberOfPayments(){
        return years * NUMBER_OF_MONTHS_IN_YEAR;
    }
}
