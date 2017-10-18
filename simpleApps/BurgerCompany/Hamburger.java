package com.Kamil;

/**
 * Created by szerlag on 2017-09-03.
 */
public class Hamburger {
    private double price;
    private String bake;
    private String meat;
    private int additions;

    public Hamburger(int price, String bake, String meat) {
        this.price = price;
        this.bake = bake;
        this.meat = meat;
        this.additions = 0;
    }

    public void addAdditions() {

        this.additions += 1;

    }

    public void addPrice() {
        this.price += 2;

    }

    public String addTomato() {
        if (this.additions < 4) {
            addAdditions();
            addPrice();
        } else System.out.println("You ordered too much additions");
        return "Tomato";

    }

    public String addOnion() {
        if (this.additions < 4) {
            addAdditions();
            addPrice();
        } else System.out.println("You ordered too much additions");
        return "Onion";

    }


    public String addChips() {
        if (this.additions < 4) {
            addAdditions();
            addPrice();
        } else System.out.println("You ordered too much additions");
        return "Chips";
    }

    public String addExtrameat() {
        if (this.additions < 4) {
            addAdditions();
            addPrice();
        } else System.out.println("You ordered too much additions");
        return "extra Meat";
    }

    public void priceforOrder() {
        System.out.println("Order Price is " + this.price + " number of additions " + this.additions);
    }

    public double getPrice() {
        return price;
    }

    public int getAdditions() {
        return additions;
    }
}

