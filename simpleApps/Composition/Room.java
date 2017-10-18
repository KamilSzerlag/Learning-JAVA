package com.Kamil;

/**
 * Created by szerlag on 2017-08-29.
 */
public class Room {
    private String light;
    private String window;
    private String floor;
    private Furniture furniture;

    public Room(String light, String window, String floor, Furniture furniture) {
        this.light = light;
        this.window = window;
        this.floor = floor;
        this.furniture = furniture;
    }
    public void wpuscAbyPoruchac(){
        System.out.println("Zaprosiles wlasnie do siebie cycata blondyneczke");
        furniture.sexinBed("jeszcze bardziej cycata blondyneczka");

    }

    public String getLight() {
        return light;
    }

    public String getWindow() {
        return window;
    }

    public String getFloor() {
        return floor;
    }
    public Furniture getFurniture() {
        return furniture;
    }
}
