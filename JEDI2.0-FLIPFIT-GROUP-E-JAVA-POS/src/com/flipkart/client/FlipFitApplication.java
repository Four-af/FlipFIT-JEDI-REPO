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
                "\n 4-> Change Password " +
                "\n 5-> Exit \n"
        );
        choice = in.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("Enter your Login Credentials");

                System.out.println("Enter your emailId:> ");
                String emailId = in.next();

                System.out.println("Enter your password:> ");
                String password = in.next();

                System.out.println("Enter your role:> Customer/Admin/GymOwner ");
                String role = in.next();

                switch (role) {
                    case "ADMIN": {
                        Admin admin = new Admin();

                        admin.setEmailId(emailId);
                        admin.setPassword(password);

                        FlipFitAdminMenu.getFlipFitAdminMenu();

                        break;
                    }
                    case "CUSTOMER": {
                        Customer customer = new Customer();

                        customer.setEmailId(emailId);
                        customer.setPassword(password);

                        FlipFitCustomerMenu.getFlipFitCustomerMenu();

                        break;
                    }
                    case "GYM OWNER": {
                        GymOwner gymOwner = new GymOwner();

                        gymOwner.setEmailId(emailId);
                        gymOwner.setPassword(password);

                        FlipFitGymOwnerMenu.getGymOwnerMenu();

                        break;
                    }
                }
                break;

            }
            case 2: {
                System.out.println("Enter your Credentials");

                System.out.println("Enter your emailId:> ");
                String emailId = in.next();

                System.out.println("Enter your password:> ");
                String password = in.next();

                System.out.println("Enter your Name:> ");
                String name = in.next();

                System.out.println("Enter your Address:> ");
                String address = in.next();

                Customer customer = new Customer();

                customer.setEmailId(emailId);
                customer.setPassword(password);

                System.out.println("<<Customer Details>>");
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Email Id: " + emailId);

                FlipFitCustomerMenu.getFlipFitCustomerMenu();

                break;
            }
            case 3: {
                System.out.println("Enter your Credentials");

                System.out.println("Enter your emailId:> ");
                String emailId = in.next();

                System.out.println("Enter your password:> ");
                String password = in.next();

                System.out.println("Enter your Name:> ");
                String name = in.next();

                System.out.println("Enter your Address:> ");
                String address = in.next();

                System.out.println("Enter your Phone No.:> ");
                String phone = in.next();

                GymOwner gymOwner = new GymOwner();

                gymOwner.setEmailId(emailId);
                gymOwner.setPassword(password);

                System.out.println("<<Customer Details>>");
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Phone No: " + phone);
                System.out.println("Email Id: " + emailId);

                FlipFitGymOwnerMenu.getGymOwnerMenu();

                break;
            }
            case 4: {
                System.out.println("Enter your role");
                String role = in.next();

                System.out.println("Enter your emailId");
                String emailId = in.next();

                System.out.println("Enter your old Password");
                String oldPassword = in.next();

                System.out.println("Enter your new Password");
                String newPassword = in.next();

                switch (role) {
                    case "ADMIN": {
                        Admin admin = new Admin();
                        admin.setPassword(newPassword);
                        break;
                    }
                    case "CUSTOMER": {
                        Customer customer = new Customer();
                        customer.setPassword(newPassword);
                        break;
                    }
                    case "GYM OWNER": {
                        GymOwner gymOwner = new GymOwner();
                        gymOwner.setPassword(newPassword);
                        break;
                    }
                }
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }
}
