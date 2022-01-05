package com.training;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte NUMBER_OF_MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;


        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($10,000 - $1,000,000): ");
            principal = scanner.nextInt();
            if (principal >= 10_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a principal amount between $10,000 and $1,000,000.");
        }

        while (true) {
            System.out.print("Annual interest (1% - 20%): ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 20) {
                monthlyInterest = annualInterest / PERCENT / NUMBER_OF_MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter an annual interest value between 1% and 20%.");
        }

        while (true) {
           System.out.print("Period (5 - 50 years): ");
           int period = scanner.nextInt();
           if (period >= 5 && period <= 50) {
               numberOfPayments = period * NUMBER_OF_MONTHS_IN_YEAR;
               break;
           }
           System.out.println("Enter a period value between 5 and 50 years.");
       }

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(mortgageFormatted);
    }
}
