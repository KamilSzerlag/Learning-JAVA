package com.Kamil;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int czas;
        Scanner scanner = new Scanner(System.in);
        czas = scanner.nextInt();
        scanner.close();

        for(int i=czas; i>=0; i--){
            System.out.println("Bomba wybuchnie za "+i);
            if(i==0)
                System.out.println("BOMBA WYBUCHA!!");

        }
        while(czas>=0){
            System.out.println("Bomba wybuchnie za "+czas);
            if(czas==0)
                System.out.println("BOMBA WYBUCHA!!");
            czas--;

        }


    }




}
