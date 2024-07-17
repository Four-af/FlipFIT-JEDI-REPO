package com.flipkart.business;

// imports

import com.flipkart.bean.Booking;
//import com.flipkart.bean
import java.util.List;

public interface BookingInterface {
    public List<Booking> getBookings(String customerId);
    public void createBooking(String customerId, String gymId, String slotId, String bookingDate, String bookingTime, String bookingStatus, String bookingAmount );
    public void deleteBooking(String bookingId);
}
