package com.Kamil;

import java.util.ArrayList;

/**
 * Created by szerlag on 2017-10-18.
 */
public class Customer {
    private String name; // imię Klienta
    private ArrayList<Double> transactions; //tworzymy Listę zawierającą transakcje

    public Customer(String name, double initialAmount) { // tworzenie konstuktora
        this.name = name;
        this.transactions = new ArrayList<Double>(); // implementacja ArrayList
        addTrasaction(initialAmount); // wywołanie metody addTransaction
    }

    public void addTrasaction(double amount){ //dodanie Transakcji
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
