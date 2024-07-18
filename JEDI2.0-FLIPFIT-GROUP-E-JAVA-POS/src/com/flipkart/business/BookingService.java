package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDAO;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public class BookingService implements BookingInterface{

    private final ScheduleService scheduleService  = new ScheduleService();
    private final SlotService slotService = new SlotService();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        //TODO: Implement later
        return false;
    }

    public void addBooking(String userName, String scheduleID) {
        boolean isAvailable = scheduleService.modifySchedule(scheduleID, -1);
        if (!isAvailable) {
            System.out.println("No seats available for the booking");
            return;
        }
        System.out.println("Booking Succesful!");

    }

    public List<Booking> getBookingByCustomerId(String customerId){
        //TODO
        return List.of();
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        //TODO
        return List.of();
    }

    public void cancelBooking(String bookingID) {
        //TODO
        System.out.println("Booking ID " + bookingID + " is cancelled");
    }

}
