package com.flipkart.bean;

import java.time.LocalTime;

public class Slot {
    private String slotId;
    private String centerID;
    private LocalTime time;

    public Slot(String slotId, String centerID, LocalTime time) {
        this.slotId = slotId;
        this.centerID = centerID;
        this.time = time;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getCenterID() {
        return centerID;
    }

    public void setCenterID(String centerID) {
        this.centerID = centerID;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}