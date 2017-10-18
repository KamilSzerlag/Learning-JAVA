package com.Kamil;

import java.util.ArrayList;

/**
 * Created by szerlag on 2017-09-13.
 */
public class Contacts {
    private ArrayList<String> ContactsList = new ArrayList<String>();

    public void addContact(String name, String phonenumber) { //DODAWANIE DO LISTY
        ContactsList.add(name);
        ContactsList.add(phonenumber);
    }
    public void modifyGroceryItem(int position, String newItem) {
        //MODYFIKACJA DANEGO ELEMENTU LISTY
        groceryList.set(position, newItem);

        System.out.println("Grocery item " + (position+1) + " has been modified.");


    }
