package com.training;

import java.util.ArrayList;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        int numOfGuesses = 0;
        ReadNumber readNumber = new ReadNumber();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        ArrayList<Integer> locations = new ArrayList<>();

        locations.add(randomNum);
        locations.add(randomNum + 1);
        locations.add(randomNum + 2);
        theDotCom.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {

            String guess = readNumber.getUserInput("Enter a number: ");
            String result = theDotCom.checkYourSelf(Integer.parseInt(guess));
            numOfGuesses++;

            if (result.equals("kill!")) {
                isAlive = false;

                System.out.println("You took " + numOfGuesses + " guesses.");
            }
            System.out.println(result);
        }
    }
}
