package com.Kamil;

/**
 * Created by szerlag on 2017-08-29.
 */
public class Furniture {
    private String Chair;
    private String Wardrobe;
    private String Bed;

    public Furniture(String chair, String wardrobe, String bed) {
        Chair = chair;
        Wardrobe = wardrobe;
        Bed = bed;
    }

    public void sexinBed(String blonde) {

        System.out.println("Ruchasz własnie cycata blondyneczke" + blonde);
    }
}
