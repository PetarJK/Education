package com.training;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        int numOfGuesses = 0;

        ReadNumber readNumber = new ReadNumber();

        SimpleDotCom theDotCom = new SimpleDotCom();

        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};

        theDotCom.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive == true) {

            String guess = readNumber.getUserInput("Enter a number: ");

            String result = theDotCom.checkYourSelf(guess);

            numOfGuesses++;

            if (result.equals("kill!")) {
                isAlive = false;

                System.out.println("You took " + numOfGuesses + " guesses.");
            }
        }
    }
}
