package com.Kamil;

public class Main {

    public static void main(String[] args) {
        Furniture theFurniture = new Furniture("black", "small", "fromRussia");
        Room theRoom = new Room("dark", "glassy", "dywan", theFurniture);


        theRoom.getFurniture().hoveringTheCarpet("wziuuu!");
        theRoom.cleanTheWindow();

    }
}
