package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.utils.UserPlan;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface FlipFitBookingDAOInterface {
    void  addBooking(String userName, String scheduleID);
    List<FlipFitBooking> getBookingByCustomerId(String customerId);
    void cancelBookingById(String bookingID);
    List<UserPlan> getCustomerPlan(String customerId);
    boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime);
    FlipFitBooking getBookingByBookingId(String bookingId);
}
