package com.Kamil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by szerlag on 2017-11-09.
 */
public class ValueBank implements IChallenge {
    ArrayList<String> ListaZakupow;
    Scanner scanner;

    public ValueBank() {
        this.ListaZakupow = new ArrayList<String>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public ArrayList<String> addValues() {
        int button;
        System.out.println("If u want to create list:");
        System.out.println("press 1" );
        System.out.println("If u want to quit:" );
        System.out.println("press 2\n");
        button = scanner.nextInt();
        scanner.nextLine();

        switch (button) {
            case 1: {
                boolean quit = false;
                do {
                    int index = 0;
                    System.out.println("Add item: ");
                    String item;
                    int button1;
                    item = scanner.nextLine();
                    System.out.println("You added " + item + " to list!");
                    ListaZakupow.add(index, item);
                    System.out.println("Do you want to add next item?");
                    System.out.println("press 1");
                    System.out.println("press 2\n");
                    button1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (button1) {
                        case 1: {index++;
                            break;
                        }
                        case 2: {
                            quit = true;
                            scanner.close();
                        }



                    }
                } while (!quit);

                return this.ListaZakupow;
               }
            case 2: {
                System.out.println("You didn't create a list, bye");
                return null;
            }
            default: {
                return null;
            }
        }


    }

    @Override
    public void readValues(/*ArrayList<String> TwojeZakupy*/) {
        System.out.println("Your list has "+ ListaZakupow.size() + " elements");
        System.out.println(ListaZakupow);
    }
}
