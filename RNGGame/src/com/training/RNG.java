package com.training;

public class RNG {

    private int magicNumber;
    private int upperLimit;

    public RNG() {
        setUpperLimit(upperLimit);
    }

    public String getString() {
        return Integer.toString(magicNumber);
    }

    public void setTheMagicNumber() {
        magicNumber = (int) (Math.random() * upperLimit);
    }

    private int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
