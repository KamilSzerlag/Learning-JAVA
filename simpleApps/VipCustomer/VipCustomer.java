package com.Kamil;

/**
 * Created by szerlag on 2017-08-15.
 */
public class VipCustomer {
    private String name;
    private double creditlimit;
    private String email;

    public VipCustomer(String name, double creditlimit, String email) {
        this.name = name;
        this.creditlimit = creditlimit;
        this.email = email;

    }
    public VipCustomer(String email) {
        this("jim",1000,email);

    }
    public VipCustomer(){
        this("Tom",2000,"Szerlagkamil@gmail.com");
    }

    public String getName() {
        return name;
    }

    public double getCreditlimit() {
        return creditlimit;
    }

    public String getEmail() {
        return email;
    }
}
