package com.training;

public class SimpleDotCom {
    private int[] locationCells;
    private int numberOfHits = 0;

    public String checkYourSelf(String userGuess){
        int guess = Integer.parseInt(userGuess);
        String result = "miss!";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit!";
                numberOfHits++;
                break;
            }
        }

        if (numberOfHits == locationCells.length) {
            result = "kill!";
        }
        System.out.println(result);
        return result;
    }

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }
}
