package com.flipkart.client;

import com.flipkart.business.CustomerBusiness;

public class CustomerClient {
    public static void main(String[] args) {
        CustomerBusiness service =new CustomerBusiness();
        service.createCustomer();
        System.out.println("delete Customer-->" +service.deleteCustomer(101));
        System.out.println("Update Customer-->" +service.updateCustomer(101));
        service.listCustomer();
    }
}
