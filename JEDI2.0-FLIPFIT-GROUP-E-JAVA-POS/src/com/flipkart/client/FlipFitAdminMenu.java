package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminService;
import com.flipkart.business.GymOwnerInterface;
import com.flipkart.business.GymOwnerService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;


public class FlipFitAdminMenu {
    private static Admin admin = new Admin();
    private static AdminInterface adminService = new AdminService();
    private static GymOwnerInterface gymOwnerService = new GymOwnerService();
    public static Scanner scanner = new Scanner(System.in);


    public boolean adminLogin(String userName, String password) {

        System.out.println("Successfully logged in");
        adminClientMainPage();
        return true;
    }

    private void handleGymOwnerApprovalRequests(){
        // print the list with indexes from 1
        System.out.println("Admin Approval for a Gym Owner ----------");

        System.out.println("(Press 0 to exit)\nEnter the Id of Gym Owner:");
        String requestGymOwnerId = scanner.next();

        if(requestGymOwnerId.equals("0")) {return;}

        System.out.println("1. Approve the request\n2. Reject the request");
        int choice = scanner.nextInt();
        if(choice == 1){
            adminService.approveGymOwner(requestGymOwnerId, true);
            System.out.println("Approved Gym Owner");
        } else if (choice == 2) {
            adminService.approveGymOwner(requestGymOwnerId, false);
            System.out.println("Disapproved Gym Owner");
        }

    }
    private void handleGymCenterApprovalRequests(){
        // print the list with indexes from 1
        System.out.println("Press 0 to EXIT_MESSAGE or Choose the Gym Centre To Modify:");
        String requestGymCenterId = scanner.next();
        if (requestGymCenterId.equals("0")) return;
//            Now Admin will select an request and we will pop up with two
        System.out.println("1. Approve the request\n2. Reject the request\n");
        int choice = scanner.nextInt();
        if(choice == 1){
            adminService.approveGymCenter(requestGymCenterId, true);
            System.out.println("Approved Gym Centre");
        } else if (choice == 2) {
            adminService.approveGymCenter(requestGymCenterId, false);
            System.out.println("Disapproved Gym Centre");
        }
        //modify the list
//            adminClientMainPage();
    }

    private void printOwnerList(List<GymOwner> gymOwnerList){
        System.out.println("-----");
        System.out.printf("%-8s\t", "ID");
        System.out.printf("%-8s\t", "NAME");
        System.out.printf("%-8s\t", "EMAIL-ID");
        System.out.printf("%11s\t", "PAN");
        System.out.printf("%23s\t\n", "IS-APPROVED");
        System.out.println("-----");
        System.out.println("");
        for(GymOwner gymOwner: gymOwnerList) {
            System.out.printf("%-8s\t", gymOwner.getUserID());
            System.out.printf("%-8s\t", gymOwner.getUserName());
            System.out.printf("%-8s\t", gymOwner.getEmail());
            System.out.printf("%-8s\t", gymOwner.getPanNumber());
            if(gymOwner.isApproved())
            {
                System.out.println("Yes\n");
            }
            else if(!gymOwner.isApproved())
            {
                System.out.println("No\n");
            } else {
                System.out.println("Pending\n");
            }
        }
        System.out.println("----");
    }

    private void printGymCentres(List<GymCenter> pendingGymCentres) {
            System.out.println("----");
            System.out.printf("%-8s\t", "CENTRE-ID");
            System.out.printf("%-8s\t", "NAME");
            System.out.printf("%-6s\t", "CITY");
            System.out.printf("%12s\t", "OWNER-ID");
            System.out.printf("%8s\t", "CAPACITY");
            System.out.printf("%-8s\t\n", "IS-APPROVED");
            System.out.println("----");
            System.out.println("");
            for(GymCenter gymCenter: pendingGymCentres) {
                System.out.printf("%-8s\t", gymCenter.getGymCentreID());
                System.out.printf("%-8s\t", gymCenter.getGymCenterName());
                System.out.printf("%-8s\t", gymCenter.getCity());
                System.out.printf("%-8s\t", gymCenter.getOwnerID());
                System.out.printf("%-8s\t", gymCenter.getCapacity());
                if(!gymCenter.isApproved()) System.out.println("No\n");
                else if(gymCenter.isApproved()) System.out.println("Yes\n");
                else System.out.println("Pending\n");
            }
            System.out.println("----");
    }

    public static void AdminMenu() {
        System.out.println("Welcome to Admin Menu");
    }

    public void adminClientMainPage(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME ADMIN!!\nLogin Time: "+currentTime);
        while(true){
            System.out.println("0. View All Gym Owners\n1. View Pending GymOwner Approval Requests\n2. View Pending GymCenter's Approval Requests\n3. Go Back To Previous Menu");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
                    List<GymOwner> allGymOwners =  gymOwnerService.viewAllGymOwners();
                    printOwnerList(allGymOwners);
                    break;
                case 1:
                    List<GymOwner> pendingGymOwners = adminService.viewPendingGymOwners();
                    printOwnerList(pendingGymOwners);
                    if(!pendingGymOwners.isEmpty()) handleGymOwnerApprovalRequests();
                    break;

                case 2:
                    List<GymCenter> pendingGymCentres = adminService.viewPendingGymCentres();//get listGymCenterIds
                    printGymCentres(pendingGymCentres);
                    if(!pendingGymCentres.isEmpty()) handleGymCenterApprovalRequests();
                    break;
                case 3:
                    return;
            }
        }
    }
}
