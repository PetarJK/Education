package com.training;

public class RNG {

    private int magicNumber;
    private int upperLimit;

    public RNG(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getString() {
        String numberToString = Integer.toString(magicNumber);
        return numberToString;
    }

    public void setTheMagicNumber() {
        magicNumber = (int) (Math.random() * upperLimit);
    }

    public int getUpperLimit() {
        return upperLimit;
    }
}
