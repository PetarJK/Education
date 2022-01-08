package com.training;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator2022 calculator;

    public MortgageReport(MortgageCalculator2022 calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule(byte years) {
        System.out.println();
        System.out.println("Payment schedule:");
        System.out.println("-----------------");
        for (short month = 1; month <= calculator.getNumberOfPayments(); month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment: " + mortgageFormatted);
    }
}
