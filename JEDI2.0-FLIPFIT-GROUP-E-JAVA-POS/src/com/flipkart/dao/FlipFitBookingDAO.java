package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.Schedule;
import com.flipkart.utils.UserPlan;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class FlipFitBookingDAO implements FlipFitBookingDAOInterface {

    private List<FlipFitBooking> bookingList = new ArrayList<>();
    private FlipFitScheduleDAO flipFitScheduleDAO = new FlipFitScheduleDAO();

    public void addBooking(String userName, String scheduleID) {
        try {
            // Simulate generating a booking ID (not from database sequence)
            String bookingId = userName + scheduleID;

            // Assuming a successful booking adds to the list
            FlipFitBooking booking = new FlipFitBooking(bookingId, userName, scheduleID);
            bookingList.add(booking);
            System.out.println("Booking added successfully");
        } catch (Exception e) {
            System.out.println("Booking failed for current slot. Try again later.");
        }
    }

    public List<FlipFitBooking> getBookingByCustomerId(String customerId) {
        List<FlipFitBooking> customerBookings = new ArrayList<>();
        for (FlipFitBooking booking : bookingList) {
            if (booking.getUserID().equals(customerId)) {
                customerBookings.add(booking);
            }
        }
//        if (customerBookings.isEmpty()) {
//            System.out.println("No bookings found for customer ID: " + customerId);
//        }
        return customerBookings;
    }

    public List<UserPlan> getCustomerPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        try {
            List<FlipFitBooking> customerBookings = getBookingByCustomerId(customerId);
            for (FlipFitBooking booking : customerBookings) {
                Schedule schedule = flipFitScheduleDAO.getSchedule(booking.getScheduleID());
                UserPlan userPlan = new UserPlan(
                        schedule.getSlotId(),
                        "123",
                        schedule.getDate().atStartOfDay().toLocalTime(),
                        schedule.getScheduleID(),
                        schedule.getDate()
                );
                allUserPlan.add(userPlan);
            }
        } catch (Exception e) {
            System.out.println("Failed to get customer plan");
        }
        return allUserPlan;
    }

    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime) {
        LocalTime endTime = localTime.plusHours(1);
        List<UserPlan> allUserPlan = getCustomerPlan(customerId);
        for (UserPlan userPlan : allUserPlan) {
            if (userPlan.getDate().equals(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
                LocalTime bookedStartTime = userPlan.getTime();
                LocalTime bookedEndTime = bookedStartTime.plusHours(1);

                if (localTime.isBefore(bookedEndTime) && endTime.isAfter(bookedStartTime)) {
                    return true; // Overlap found
                }
            }
        }
        return false; // No overlap
    }

    public void cancelBookingById(String bookingID) {
        FlipFitBooking bookingToRemove = null;
        for (FlipFitBooking booking : bookingList) {
            if (booking.getBookingID().equals(bookingID)) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookingList.remove(bookingToRemove);
            System.out.println("Booking canceled successfully");
        } else {
            System.out.println("Could not cancel booking for BookingId: " + bookingID);
        }
    }

    public FlipFitBooking getBookingByBookingId(String bookingId) {
        for (FlipFitBooking booking : bookingList) {
            if (booking.getBookingID().equals(bookingId)) {
                return booking;
            }
        }
        System.out.println("Could not fetch booking by bookingId: " + bookingId);
        return null;
    }
}