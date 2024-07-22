package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.UserInvalidException;

public interface FlipFitCustomereDAOInterface {
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) throws RegistrationFailedException;
    public boolean isUserValid(String userName, String password) throws UserInvalidException;
    FlipFitCustomer getCustomerById(String userName);
}