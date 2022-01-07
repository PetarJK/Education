package com.training;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte NUMBER_OF_MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal amount", 5_000, 1_000_000);
        float annualInterest = (float) readNumber("Annual interest", 1, 20);
        byte years = (byte) readNumber("Period", 5, 50);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment: " + mortgageFormatted);
        System.out.println();
        System.out.println("Payment schedule:");
        System.out.println("-----------------");
        for (short month = 1; month <= years * NUMBER_OF_MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
        int numberOfPayments = years * NUMBER_OF_MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
        int numberOfPayments = years * NUMBER_OF_MONTHS_IN_YEAR;

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1));
        return mortgage;
    }

    public static double readNumber(String prompt, double min, double max) {

        var scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }
}
