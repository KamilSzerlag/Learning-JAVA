package simpleApps.InterfacesChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by szerlag on 2017-11-09.
 */
public class ValueBank implements IChallenge {
    
    private List<String> listaZakupow = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    @Override
    public List<String> addValues() {
        System.out.println("If u want to create list:");
        System.out.println("press 1");
        System.out.println("If u want to quit:");
        System.out.println("press 2\n");
        int button = getButton();

        switch (button) {
            case 1: {
                boolean quit = false;
                do {
                    int index = 0;
                    System.out.println("Add item: ");
                    String item = getNextLine();
                    System.out.println("You added " + item + " to list!");
                    listaZakupow.add(index, item);
                    System.out.println("Do you want to add next item?");
                    System.out.println("press 1");
                    System.out.println("press 2\n");
                    int button1 = getButton();
                    getNextLine();
                    switch (button1) {
                        case 1: {
                            index++;
                            break;
                        }
                        case 2: {
                            quit = true;
                            scanner.close();
                        }


                    }
                } while (!quit);

                return listaZakupow;
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

    private String getNextLine() {
        return scanner.nextLine();
    }

    private int getButton() {
        return scanner.nextInt();
    }

    @Override
    public void readValues(/*ArrayList<String> TwojeZakupy*/) {
        System.out.println("Your list has " + listaZakupow.size() + " elements");
        System.out.println(listaZakupow);
    }
}
