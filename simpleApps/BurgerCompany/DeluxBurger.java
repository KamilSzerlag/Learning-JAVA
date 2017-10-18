package com.Kamil;

/**
 * Created by szerlag on 2017-09-04.
 */
public class DeluxBurger extends Hamburger {
    private String chips;
    private String drinks;
    public DeluxBurger() {
        super(25, "normal", "becon");
        this.chips="chips";
        this.drinks="drinks";
        System.out.println("You have ordered Deluxe burger with " + this.chips +" & " + this.drinks + "in"  + getPrice());
    }


}
