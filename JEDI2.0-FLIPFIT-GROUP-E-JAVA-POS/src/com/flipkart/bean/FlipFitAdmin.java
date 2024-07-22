package com.flipkart.bean;

public class FlipFitAdmin extends FlipFitUser {

    public FlipFitAdmin() {
        super("123","admin", "admin@flipfit.com", "12345", FlipFitRole.ADMIN);
    }
}