package com.Kamil;

/**
 * Created by szerlag on 2017-09-03.
 */
public class Healthyburger extends Hamburger {
    public Healthyburger(int price, String meat) {
        super(price, "brown rye bread roll", meat);
    }



    public String addGlutenFreeKetchup() {
        if(getAdditions()<6){
        super.addAdditions();
        addPrice();}
        else System.out.println(" You ordered to much additions");
        return "Gluten Free Ketchup";


    }

    public String addDieteticOil() {
        if(getAdditions()<6){
        super.addAdditions();
        addPrice();}
        else System.out.println(" You ordered to much additions");
        return "Dieteric Oil";

    }
}
