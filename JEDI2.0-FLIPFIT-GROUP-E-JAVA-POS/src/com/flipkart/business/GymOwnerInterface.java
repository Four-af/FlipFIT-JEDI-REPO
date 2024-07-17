package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Customer;
import com.flipkart.bean.User;


public interface GymOwnerInterface {
    public List<Booking> viewBookedSlots(String userId);
    public Booking checkBookingConflicts(String userId, String slotTime);
    public List<GymCenter> viewCenters();
    public boolean makePayment(String userId);
    public Customer editDetails(Customer customer);
    public User login(User user);
    public Customer registerCustomer(Customer customer);
}
