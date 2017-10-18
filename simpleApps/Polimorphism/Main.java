package com.Kamil;

class Car {
    private String engine;
    private int cylinders;
    private int wheels;

    public Car(String engine, int cylinders) {
        this.engine = engine;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String getEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String startEngine() {
        return "Engine is ON";


    }

}

class Porsche extends Car {
    public Porsche() {
        super("V8", 8);
    }

    public String startEngine() {
        return "V8 is ON";

    }
}

class Ferrari extends Car {
    public Ferrari() {
        super("V12", 12);
    }

    @Override
    public String startEngine() {
        return "V12 is ON";

    }
}

public class Main {


    public static void main(String[] args) {
        Car myCar = new Porsche();
        System.out.println(myCar.startEngine());
        myCar.startEngine();
        Car nextCar = new Ferrari();
        System.out.println(nextCar.startEngine());

    }
}
