package com.training;

import java.util.ArrayList;

public class SimpleDotCom {
    public ArrayList<Integer> locationCells = new ArrayList<>();

    public String checkYourSelf(int userGuess){
        String result = "miss!";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill!";
            } else {
                result = "hit!";
            }
        }
        return result;
    }

    public void setLocationCells(ArrayList<Integer> locationCells) {
        this.locationCells = locationCells;
    }
}
