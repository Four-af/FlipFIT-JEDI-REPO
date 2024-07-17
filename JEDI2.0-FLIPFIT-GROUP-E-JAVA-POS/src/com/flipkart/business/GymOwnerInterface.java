package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.User;

import java.util.List;

public interface GymOwnerInterface {
    public List<Booking> viewBookedSlots(int userId);
    public Booking checkBookingConflicts(int userId, int slotTime);
    public List<GymCenter> viewCentres();
    public boolean makePayment(int userId);
    public Customer editDetails(Customer flipFitGymCustomer);
    public User login(User flipFitUser);
    public Customer registerCustomer(Customer flipFitGymCustomer);
}
