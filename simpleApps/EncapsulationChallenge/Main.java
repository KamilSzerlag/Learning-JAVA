package com.Kamil;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(200, 0, true);

        printer.printPage(5, true);
        printer.checkTonerlevel();
        printer.printPage(10, false);
        printer.checkTonerlevel();
        printer.fillupToner();
        printer.checkTonerlevel();
        printer.printPage(5, true);
        printer.checkTonerlevel();
    }
}
