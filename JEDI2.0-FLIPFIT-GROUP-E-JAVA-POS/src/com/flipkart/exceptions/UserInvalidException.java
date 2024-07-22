package com.flipkart.exceptions;

// Custom exception thrown when user is invalid
public class UserInvalidException extends Exception {
    public UserInvalidException(String message) {
        super(message);
    }
}