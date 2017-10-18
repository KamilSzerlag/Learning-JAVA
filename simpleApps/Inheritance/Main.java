package com.Kamil;

public class Main {

    public static void main(String[] args) {
        Car Volswagen = new Car("golf", "tdi", 4, 1, 3, 50);
        Volswagen.carSpeed();
        Volswagen.faster();
        Volswagen.slower();
        Volswagen.reduceGear();
        Volswagen.upGear();
        SportCar porsche = new SportCar("up", "akrapovic", 1);
        porsche.carSpeed();
        porsche.useNitro();
        porsche.carSpeed();
        porsche.faster();
        porsche.slower();
        porsche.reduceGear();
        porsche.upGear();
        porsche.useSpoiler();
    }
}
