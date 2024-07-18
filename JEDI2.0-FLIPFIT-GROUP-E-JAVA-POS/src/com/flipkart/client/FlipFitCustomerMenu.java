package com.flipkart.client;

//imports
import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerInterface;
import com.flipkart.business.CustomerService;
import com.flipkart.utils.Util;
import com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class FlipFitCustomerMenu {
    private CustomerInterface customerService  =  new CustomerService();
    Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String userName, String password) throws ParseException {
        if (customerService.isUserValid(userName, password)) {
            System.out.println("Successfully logged in");
            customerClientMainPage(userName);
        } else {
            System.out.println("UserName or password doesn't match");
            return false;
        }
        return true;
    }


    public void register() throws ParseException {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Password");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        customerService.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        customerClientMainPage(userName);
    }

    private void printSlots(List<Slot> slots){
        System.out.println("-----");
        System.out.printf("%-8s\t", "SLOT-ID");
        System.out.printf("%-8s\t\n", "SLOT-TIME");
        System.out.println("----");
        for(Slot slot: slots) {
            System.out.printf("%-8s\t", slot.getSlotId());
            System.out.printf("%-8s\t\n", slot.getTime());
        }
        System.out.println("----");
    }

    private void bookSlotSubMenu(String userName) throws ParseException {
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        List<GymCenter> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);
        Util.printGymCentres(centreListByLocation);
        if(centreListByLocation.isEmpty()){
            System.out.println("There are no available GYM Centres in " + location + ". Please Select some other location");
            bookSlotSubMenu(userName);
            return;
        }
        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();
        Date sqlDate = selectDate();
        chooseSlot(chosenGym,userName,sqlDate,chosenGym);
    }

    private Date selectDate() throws ParseException {
        //Select Date
        System.out.print("Enter Date (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        Date sqlDate = null;
        String dat = scanner.next();
        date = sdf.parse(dat);
        sqlDate = new Date(date.getTime());
        return sqlDate;
    }

    private void chooseSlot(String gymCentreId,String userName,Date sqlDate,String centreId) throws ParseException {
        System.out.println("Choose from the Below Slots");
        List<Slot> availableSlots = customerService.getAvailableSlots(gymCentreId,sqlDate);
        printSlots(availableSlots);
        if(availableSlots.isEmpty()){
            System.out.println("There are no available slots in the " + gymCentreId + ". Please Select some other gym");
            bookSlotSubMenu(userName);
            return;
        }
        System.out.println("Enter SlotID");
        String slotID = scanner.next();
        if(!customerService.bookSlot(userName,sqlDate,slotID,centreId)) chooseSlot(gymCentreId, userName, sqlDate,centreId);
    }

    private void printUserPlan(String userName){
        System.out.println("Bookings : ");
        List<UserPlan> allUserPlan= customerService.getCustomerPlan(userName);
        List<Booking> bookingList = customerService.getCustomerBookings(userName);
        System.out.println("-----");
        System.out.printf("%-8s\t", "Centre-ID");
        System.out.printf("%-8s\t", "SLOT-ID");
        System.out.printf("%-8s\t", "DATE");
        System.out.printf("%8s\t", "SLOT-TIME");
        System.out.printf("%-8s\t\n", "SCHEDULE_ID");
        System.out.println("-----");
        for(UserPlan userPlan: allUserPlan) {
            System.out.printf("%-8s\t", userPlan.getCentreID());
            System.out.printf("%-8s\t", userPlan.getSlotId());
            System.out.printf("%-8s\t", userPlan.getDate());
            System.out.printf("%-8s\t", userPlan.getTime());
            System.out.printf("%-8s\t\n", userPlan.getScheduleID());
        }
        System.out.println("-----");
    }

    private void printbookingsSubMenu(String userName){
        System.out.println("Bookings : ");
        List<Booking> allBookingList= customerService.getCustomerBookings(userName);
        System.out.println("-----");
        System.out.printf("%-8s\t", "BOOKING-ID");
        System.out.printf("%47s\t\n", "SCHEDULE-ID");
        System.out.println("-----");
        for(Booking booking: allBookingList) {
            System.out.printf("%-8s\t", booking.getBookingID());
            System.out.printf("%-8s\t\n", booking.getScheduleID());
        }
        System.out.println("----");
    }

    private void cancelBookingSubMenu(String userName){
        System.out.println("Select the Booking you want to cancel: ");
        printbookingsSubMenu(userName);
        String bookingId = scanner.next();
        customerService.cancelBookingbyID(bookingId);

    }

    public void printCustomerProfile(Customer customer){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("USER ID: " + customer.getUserID());
        System.out.println("USER NAME: " + customer.getUserName());
        System.out.println("EMAIL: " + customer.getEmail());
        System.out.println("CONTACT: " + customer.getCustomerPhone());
        System.out.println("CARD DETAILS: " + customer.getCardDetails());
        System.out.println("------------------------------------------------------------------------");
    }

    public static void getCustomerMenu() {
        System.out.println("Welcome to Customer Menu");
    }

    public void customerClientMainPage(String userName) throws ParseException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+ userName+" !!\nWhat you what to do\nLogin TIME: "+ currentTime);
        while(true){
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    Customer customer= customerService.viewMyProfile(userName);
                    printCustomerProfile(customer);
                    break;
                case 2:
                    bookSlotSubMenu(userName);
                    break;
                case 3:
                    printUserPlan(userName);
                    break;
                case 4:
                    cancelBookingSubMenu(userName);
                    break;
                case 5:
                    System.out.println("Taking back to previous menu");
                    return;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }
    }
}
