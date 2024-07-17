package com.flipkart.business;

public interface SlotInterface {
    boolean addPersonToWaitlist(String slotId,String customerId,String gymId,String time);
    boolean promoteWaitlist(String customerId, String gymId, String slotId, String bookingDate, String bookingTime, String bookingStatus, String bookingAmount );
}
