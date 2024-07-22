package com.flipkart.business;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public interface FlipFitCustomerInterface {
    List<FlipFitGymCenter> getAllGymCenterDetailsByCity(String city);
    List<Slot> getAvailableSlots(String centreID, Date date);
    List<FlipFitBooking> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBookingByID(String bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    FlipFitCustomer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);

    List<UserPlan> getCustomerPlan(String userName);

    void cancelBookingbyID(String bookingId);
}