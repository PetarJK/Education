package com.training;

import java.util.ArrayList;

public class DotComBust {
    private UserInputAndGrid userInput = new UserInputAndGrid();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numberOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();
        one.setName("Google.com");
        two.setName("FaceBook.com");
        three.setName("Blizzard.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println();
        System.out.println("Your goal is to sink all three Dot Coms which are placed on a 7x7 grid(A - G, 0 - 6)..." +
                " you know... battleships.");
        System.out.println();
        System.out.println(one.getName() + ", " + two.getName() + ", " + three.getName() + ".");
        System.out.println();
        System.out.println("Try to sink them all in the fewest number of guesses.");
        System.out.println();

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = userInput.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void gameStart() {
        setUpGame();
        while (!dotComList.isEmpty()) {
            String userGuess = userInput.getUserInput("FIRE: ");
            checkUserGuess(userGuess);
        }
        gameFinish();
    }

    private void checkUserGuess(String userGuess) {
        numberOfGuesses++;
        String result = "miss!";

        for (int x = 0; x < dotComList.size(); x++) {
            result = dotComList.get(x).checkYourself(userGuess);

            if (result.equals("hit!")) {
                break;
            }
            if (result.equals("kill!")) {
                dotComList.remove(x);
                break;
            }
        }
        System.out.println(result);
        System.out.println();
    }

    private void gameFinish() {
        System.out.println();
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        System.out.println();
        if (numberOfGuesses < 18) {
            System.out.println("It only took you " + numberOfGuesses + " guesses.");
            System.out.println();
            System.out.println("For once in in yor life, you've pulled out just in time. :)");
        } else {
            System.out.println("Not the sharpest tool in the shed, are you? You took " + numberOfGuesses + " guesses.");
            System.out.println();
            System.out.println("You should consider knitting, not investments.");
        }
    }
}
