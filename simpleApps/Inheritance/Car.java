package com.Kamil;

/**
 * Created by szerlag on 2017-08-17.
 */
public class Car {
    private String model;
    private String engine;
    private int wheeles;
    private int sterring_wheel;
    private int gear;
    public int speed;

    public Car(String model, String engine, int wheeles, int sterring_wheel, int gear, int speed) {
        this.model = model;
        this.engine = engine;
        this.wheeles = wheeles;
        this.sterring_wheel = sterring_wheel;
        this.gear = gear;
        this.speed = speed;
    }

    public void yourModel(String model) {
        this.model = model;
        System.out.println(" Our Car is " + model);

    }

    public void engineON(String engine) {
        this.engine = engine;
        System.out.println(" This engine is a " + engine);
    }

    public void wheeles(int wheeles) {

    }

    public void gear(int gear) {
        this.gear = gear;
        System.out.println("your gear is" + gear);

    }

    public int upGear() {
        if (this.gear < 6) {
            this.gear += 1;
            System.out.println(" your gear is " + gear);
        } else {
            System.out.println("you are using the highest gear");
        }
        return gear;
    }

    public int reduceGear() {
        if (this.gear > 1) {
            this.gear -= 1;
            System.out.println(" your gear is " + gear);
        } else {
            System.out.println("you are using the lowest gear");
        }
        return gear;
    }

    public int carSpeed() {
        System.out.println(" Car speed is " + this.speed);
        return speed;
    }

    public int faster() {
        this.speed += 10;
        if (speed < 200) {
            System.out.println(" your speed is " + speed);
        } else {
            System.out.println("you are riding to fast!");
        }
        return speed;
    }

    public int slower() {
        if (speed >= 10) {
            this.speed -= 10;
            System.out.println(" your speed is " + speed);
        } else {
            System.out.println(" you are staying in plac ");
        }
        return speed;


    }
}