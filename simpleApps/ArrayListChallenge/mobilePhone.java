package com.Kamil;

import java.util.ArrayList;

/**
 * Created by szerlag on 2017-10-07.
 */
public class mobilePhone {
    private String myPhone;
    private ArrayList<Contact> myContacts;

    public mobilePhone(String myPhone, ArrayList<Contact> myContacts) {
        this.myPhone = myPhone;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean Addnewcontact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size();i++ ){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName))

        }
    }
}
