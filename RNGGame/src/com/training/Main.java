package com.training;

public class Main {

    public static void main(String[] args) {

        var gameDialog = new InputAndDialog();
        var magicNumber = new RNG(10);
        int attempts = 5;

        String newGameAnswer = gameDialog.inputDialog("Start a new game? Type \"yes\" to continue or \"no\" to quit.");

        while (newGameAnswer.equals("yes")) {
            magicNumber.setTheMagicNumber();
            String numberToString = magicNumber.getString();
            String userGuess = gameDialog.inputDialog(
                    "Try to guess the magic number between 0 and " + magicNumber.getUpperLimit()
                            + ". You have " + attempts + ".");
            for (int i = 1; i < attempts; i++) {
                if (userGuess.equals(numberToString)) {
                    gameDialog.dialog("WINNER WINNER CHICKEN DINER!");
                    break;
                }
                if (!userGuess.equals(numberToString))
                    userGuess = gameDialog.inputDialog("Try again: ");
            }
            gameDialog.dialog("GAME OVER!");
            newGameAnswer = gameDialog.inputDialog("Another game? Type \"yes\" to continue or \"no\" to quit.");
        }
    }
}