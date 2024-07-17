package com.flipkart.business;

import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class SlotService implements SlotInterface {
    private Map<String, WaitlistEntry> waitlist = new HashMap<>();

    @Override
    public boolean addPersonToWaitlist(String slotId, String customerId, String gymId, String time) {
        String key = slotId + ":" + customerId + ":" + gymId + ":" + time;
        if (!waitlist.containsKey(key)) {
            waitlist.put(key, new WaitlistEntry(slotId, customerId, gymId, time));
            return true;
        }
        return false;
    }

    @Override
    public boolean promoteWaitlist(String customerId, String gymId, String slotId, String bookingDate, String bookingTime, String bookingStatus, String bookingAmount) {
        // Add logic to promote a person from the waitlist
        String key = slotId + ":" + customerId + ":" + gymId + ":" + bookingTime;
        if (waitlist.containsKey(key)) {
            // Perform promotion logic
            waitlist.remove(key);
            // Add booking logic here (e.g., add to booking database or list)
            return true;
        }
        return false;
    }

    private static class WaitlistEntry {
        private String slotId;
        private String customerId;
        private String gymId;
        private String time;

        public WaitlistEntry(String slotId, String customerId, String gymId, String time) {
            this.slotId = slotId;
            this.customerId = customerId;
            this.gymId = gymId;
            this.time = time;
        }

        // Getters and setters (if needed)
    }

    // Simulated storage for slots (replace with actual database integration as needed)
    private List<Slot> slotStorage = new ArrayList<>();

    public List<Slot> getAllSlotsByCentre(String centreID) {
        List<Slot> slotsByCentre = new ArrayList<>();
        for (Slot slot : slotStorage) {
            if (slot.getCenterID().equals(centreID)) {
                slotsByCentre.add(slot);
            }
        }
        return slotsByCentre;
    }

    public Slot getSlotByID(String slotID) {
        for (Slot slot : slotStorage) {
            if (slot.getSlotId().equals(slotID)) {
                return slot;
            }
        }
        return null;
    }

    public Slot getSlotByIDandCentreId(String slotID, String centreId) {
        for (Slot slot : slotStorage) {
            if (slot.getSlotId().equals(slotID) && slot.getCenterID().equals(centreId)) {
                return slot;
            }
        }
        return null;
    }

    public List<Slot> getSlotList() {
        return new ArrayList<>(slotStorage);
    }

    public void addSlotsForGym(String gymCentreId, List<Slot> slotList) {
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for (Slot slot : slotList) {
            slot.setCenterID(gymCentreId);
            slotStorage.add(slot); // Simulate adding to storage
        }
    }

    public boolean isSlotValid(String slotID, String centreId) {
        return getSlotByIDandCentreId(slotID, centreId) != null;
    }
}
