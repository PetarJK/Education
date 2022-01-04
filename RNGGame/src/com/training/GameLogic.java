package com.training;

public class GameLogic {

    private int attempts;
    private int upperLimit;
    private RNG magicNumber = new RNG();
    private InputAndDialog gameDialog = new InputAndDialog();

    public GameLogic(int attempts, int upperLimit) {
        this.attempts = attempts;
        this.upperLimit = upperLimit;
    }

    public void newGame() {
        magicNumber.setUpperLimit(upperLimit);
        String newGameConfirmation = gameDialog.inputDialog(
                "Start a new game? Type \"yes\" to continue or \"no\" to quit.");

        while (newGameConfirmation.equals("yes")) {
            magicNumber.setTheMagicNumber();
            String numberToString = magicNumber.getString();
            String userGuess = gameDialog.inputDialog(
                    "Try to guess the magic number between 0 and " + upperLimit + ". You have " + attempts + ".");
            for (int i = 1; i < attempts; i++) {
                if (userGuess.equals(numberToString)) {
                    gameDialog.dialog("WINNER WINNER CHICKEN DINER!");
                    break;
                }
                if (!userGuess.equals(numberToString))
                    userGuess = gameDialog.inputDialog("Try again: ");
            }
            gameDialog.dialog("GAME OVER!");
            newGameConfirmation = gameDialog.inputDialog("Another game? Type \"yes\" to continue or \"no\" to quit.");
        }
    }
}
