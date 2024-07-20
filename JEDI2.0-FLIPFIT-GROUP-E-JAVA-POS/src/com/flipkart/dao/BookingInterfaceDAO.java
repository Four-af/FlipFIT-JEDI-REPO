package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.utils.UserPlan;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface BookingInterfaceDAO {
    void  addBooking(String userName, String scheduleID);
    List<Booking> getBookingByCustomerId(String customerId);
    void cancelBookingById(String bookingID);
    List<UserPlan> getCustomerPlan(String customerId);
    boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime);
    Booking getBookingByBookingId(String bookingId);
}
