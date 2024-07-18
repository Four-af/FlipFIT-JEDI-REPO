package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomerDAO  {
    private Map<String, Customer> customers = new HashMap<>();


    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        if (customers.containsKey(userName)) {
            System.out.println("User already exists.");
        }
        Customer customer = new Customer(UUID.randomUUID().toString(), userName, password, email, phoneNumber, cardNumber);
        customers.put(userName, customer);
    }

    public boolean isUserValid(String userName, String password) {
        Customer customer = customers.get(userName);
        if (customer != null && customer.getPassword().equals(password)) {
            return true;
        } else {
            System.out.println("User is Invalid. Try again.");
            return false;
        }
    }

    public Customer getCustomerById(String userName) {
        return customers.get(userName);
    }
}

