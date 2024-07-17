package com.flipkart.business;

import com.flipkart.bean.Slot;

import java.util.List;
public interface SlotInterface {
    boolean addPersonToWaitlist(String slotId,String customerId,String gymId,String time);
    boolean promoteWaitlist(String customerId, String gymId, String slotId, String bookingDate, String bookingTime, String bookingStatus, String bookingAmount );
    List<Slot> getAllSlotsByCentre(String centreID);
    Slot getSlotByID(String slotID);
    List<Slot> getSlotList();
    void addSlotsForGym(String gymCentreId, List<Slot> slotList);
    boolean isSlotValid(String slotID,String centreId);
}
