package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class BookingDAO implements BookingInterfaceDAO{
    @Override
    public void addBooking(String userName, String scheduleID) {
        System.out.println("Added Booking");
    }

    @Override
    public List<Booking> getBookingByCustomerId(String customerId) {
        return List.of();

    }

    @Override
    public void cancelBookingById(String bookingID) {
        System.out.println("Booking Cancelled");
    }
    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime)
        {

            return true;
        }

    public List<UserPlan> getCustomerPlan(String customerId) {
        System.out.println("Getting user plan");
        return List.of();
    }
    public Booking getBookingByBookingId(String bookingId) throws RuntimeException{
        System.out.println("Getting booking Id");
        return null;
    }
}
