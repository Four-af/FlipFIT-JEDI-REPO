package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookingGymInterface {
    public void createBooking(String userId, String gymId, String bookingDate, String bookingTimeSlot);
    public void bookSlots() throws RuntimeException;
    public List<Booking> viewBookings(String userId) throws RuntimeException;
    public void cancelBookings(String bookingId) throws RuntimeException;

}
