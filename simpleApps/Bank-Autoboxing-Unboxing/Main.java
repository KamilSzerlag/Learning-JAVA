package com.Kamil;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Bank SKOK");

        bank.addBranch("Rzeszow");

        bank.addCustomer("Rzeszow","Jacek", 210.120);
        bank.addCustomer("Rzeszow", "Tomek", 192.100);

        bank.addBranch("Sidney");
        bank.addCustomer("Sidney","Bob",120.20);

        bank.addCustomerTransaction("Rzeszow","Jacek", 44.22);
        bank.addCustomerTransaction("Rzeszow","Tomek", 22.21);

        bank.listCustomers("Rzeszow",true);
	// write your code here
    }
}
