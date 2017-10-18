package com.Kamil;

import java.util.ArrayList;

/**
 * Created by szerlag on 2017-10-18.
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customers; //Tworzymy listę zawierającą Klientów

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>(); // implementacja ArrayList z klientami
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;

        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTrasaction(amount);
            return true;
        }
        return false;

    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}