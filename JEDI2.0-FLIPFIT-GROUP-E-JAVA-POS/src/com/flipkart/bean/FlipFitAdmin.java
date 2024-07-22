package com.flipkart.bean;
// Admin for FlipFit
public class FlipFitAdmin extends FlipFitUser {

    public FlipFitAdmin() {
        super("123","admin", "admin@flipfit.com", "admin", FlipFitRole.ADMIN);
    }
}