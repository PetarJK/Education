package com.training;

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal amount", 5_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual interest", 1, 20);
        byte years = (byte) Console.readNumber("Period", 5, 50);

        var calculator = new MortgageCalculator2022(principal, annualInterest, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule(years);
    }
}
