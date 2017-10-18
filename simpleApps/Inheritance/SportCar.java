package com.Kamil;

/**
 * Created by szerlag on 2017-08-17.
 */
public class SportCar extends Car {
    private String spoiler;
    private String sportExhaust;
    private int nitro;

    public SportCar(String spoiler, String sportExhaust, int nitro) {
        super("porsche", "V8", 4, 1, 1, 0);
        this.spoiler = spoiler;
        this.sportExhaust = sportExhaust;
        this.nitro = nitro;
    }

    public void useSpoiler() {
        if (spoiler.equals("down")) {
            this.spoiler = "up";
            System.out.println("Spoiler is up");
        } else {
            System.out.println("Spoiler is already up");
        }
    }

    public void useNitro() {
        faster();// chce zmienic obiektowi klasy SportCar speed przy pomocy metodu useNitro, jak sie odwolac do tej zmiennej?
        carSpeed();

    }

    @Override
    public int faster() {
        super.speed+=25;
        return super.faster();
    }
}
