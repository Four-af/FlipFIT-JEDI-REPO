package com.flipkart.bean;

/**
 * Represents a booking made by a user for a specific schedule.
 */
public class Booking {

    private String bookingID;    // Unique identifier for the booking
    private String userID;       // User ID of the user making the booking
    private String scheduleID;   // ID of the schedule being booked

    /**
     * Constructor for creating a new booking without a predefined booking ID.
     * @param userID User ID of the user making the booking
     * @param scheduleID ID of the schedule being booked
     */
    public Booking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Constructor for creating a new booking with a predefined booking ID.
     * @param bookingID Unique identifier for the booking
     * @param userID User ID of the user making the booking
     * @param scheduleID ID of the schedule being booked
     */
    public Booking(String bookingID, String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    /**
     * Retrieves the booking ID.
     * @return The booking ID
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Sets the booking ID.
     * @param bookingID The booking ID to set
     */
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Retrieves the user ID of the user who made the booking.
     * @return The user ID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user ID of the user who made the booking.
     * @param userID The user ID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the schedule ID of the schedule being booked.
     * @return The schedule ID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * Sets the schedule ID of the schedule being booked.
     * @param scheduleID The schedule ID to set
     */
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

}
