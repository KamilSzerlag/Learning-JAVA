package com.Kamil;

/**
 * Created by szerlag on 2017-09-02.
 */
public class Printer {
    private int tonerLevel = 100;
    private int pagesNumber=0;
    private boolean duplex = false;

    public Printer(int tonerLevel, int pagesNumber, boolean duplex) {
        if (tonerLevel <= 100 && tonerLevel >= 0) {
            this.tonerLevel = tonerLevel;
        }
        this.pagesNumber = pagesNumber;
        if (duplex == true) {
            this.duplex = duplex;
        }
    }

    public void printPage(int pagesNumber, boolean duplex){
        this.pagesNumber=pagesNumber;
        if(duplex==false){
        this.tonerLevel-=1*pagesNumber;}
        else{
            this.tonerLevel-=2*pagesNumber;
        }
        System.out.println("you are printing " + pagesNumber);
    }
    public void fillupToner(){
        this.tonerLevel=100;
        System.out.println("your toner is now full");
    }
    public void checkTonerlevel(){
        System.out.println("Toner level is " + this.tonerLevel);
    }
}
