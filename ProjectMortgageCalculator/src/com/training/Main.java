package com.training;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte NUMBER_OF_MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        var scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual interest: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;

        System.out.print("Period: ");
        int period = scanner.nextInt();
        int numberOfPayments = period * NUMBER_OF_MONTHS_IN_YEAR;

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(mortgageFormatted);
    }
}
