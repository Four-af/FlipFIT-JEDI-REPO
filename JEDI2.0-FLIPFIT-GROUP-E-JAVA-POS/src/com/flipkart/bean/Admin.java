package com.flipkart.bean;

public class Admin extends User {

    public Admin() {
        super("123","admin", "admin@flipfit.com", "admin", Role.ADMIN);
    }
}