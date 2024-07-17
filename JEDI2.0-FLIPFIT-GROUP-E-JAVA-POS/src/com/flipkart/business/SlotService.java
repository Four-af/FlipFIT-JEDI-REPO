package com.flipkart.business;

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
}
