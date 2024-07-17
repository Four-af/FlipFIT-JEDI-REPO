package com.flipkart.business;

import com.flipkart.bean.Booking;

public interface GymOwnerInterface {
    public List<Booking> viewBookedSlots(int userId);
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    public List<FlipFitGymCentre> viewCentres();
    public boolean makePayment(int userId);
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException;
    public FlipFitUser login(FlipFitUser flipFitUser);
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer);
}
