package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;

import java.util.Scanner;
import java.util.UUID;

public class FlipFitApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome To FlipFit: ");
        System.out.println("Type " +
                "\n 1-> Login, " +
                "\n 2-> Registration of Customer " +
                "\n 3-> Registration of Gym Owner " +
                "\n 4-> Exit \n"
        );
        choice = in.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("Enter your Login Credentials");
                System.out.print("Enter your emailId:> ");
                String emailId = in.next();
                System.out.print("Enter your password:> ");
                String password = in.next();
                System.out.print("Enter your role:> Customer/Admin/GymOwner ");
                String role = in.next();

                switch (role) {
                    case "ADMIN": {
                        String adminId = UUID.randomUUID().toString();
                        Admin admin = new Admin();
                        admin.setAdminId(adminId);
                        admin.setEmailId(emailId);
                        admin.setPassword(password);
                        FlipFitAdminMenu.getFlipFitAdminMenu();
                        break;
                    }
                    case "CUSTOMER": {
                        String customerId = UUID.randomUUID().toString();
                        Customer customer = new Customer();
                        customer.setCustomerID(customerId);
                        customer.setEmailId(emailId);
                        customer.setPassword(password);
                        FlipFitCustomerMenu.getFlipFitCustomerMenu();
                        break;
                    }
                    case "GYM OWNER": {
                        String gymOwnerId = UUID.randomUUID().toString();
                        GymOwner gymOwner = new GymOwner();
                        gymOwner.setEmailId(emailId);
                        gymOwner.setPassword(password);
                        FlipFitGymOwnerMenu.getGymOwnerMenu();
                        break;
                    }
                }
            }
        }
    }
}
