package com.flipkart.exceptions;

import static com.flipkart.constants.Constants.RED_COLOR;
import static com.flipkart.constants.Constants.RESET_COLOR;

// Custom exception thrown when registration fails
public class RegistrationFailedException extends Exception {
    public RegistrationFailedException(String gymOwnerId) {
        super(RED_COLOR+"Failed to register Gym Owner with id: " + gymOwnerId+RESET_COLOR);
    }
}