package com.training;

public class Quote {
    final private String site;
    final private int price; //used int for simplicity.

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote from " + site + " : " + "price = " + price;
    }

    public String getSite() {
        return site;
    }

    public int getPrice() {
        return price;
    }
}
