package com.flipkart.business;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;
public interface FlipFitSlotInterface {
//    boolean addPersonToWaitlist(String slotId,String customerId,String gymId,String time);
//    boolean promoteWaitlist(String customerId, String gymId, String slotId, String bookingDate, String bookingTime, String bookingStatus, String bookingAmount );
    List<FlipFitSlot> getAllSlotsByCentre(String centreID);
    FlipFitSlot getSlotByID(String slotID);
    List<FlipFitSlot> getSlotList();
    void addSlotsForGym(String gymCentreId, List<FlipFitSlot> slotList);
    boolean isSlotValid(String slotID,String centreId);
    FlipFitSlot getSlotByIDCentreId(String slotID, String centreId);
}
