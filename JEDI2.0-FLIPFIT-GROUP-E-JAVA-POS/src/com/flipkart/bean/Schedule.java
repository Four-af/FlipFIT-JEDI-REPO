package com.flipkart.bean;

import java.time.LocalDate;
import java.util.UUID;


public class Schedule {
    private String scheduleID;
    private String slotId;
    private int availability;
    private LocalDate date;


    public Schedule(LocalDate date, String slotId, int availability) {
        this.scheduleID =UUID.randomUUID().toString();
        this.date = date;
        this.slotId = slotId;
        this.availability = availability;
    }


    public void setScheduleID(String ScheduleID) {
        this.scheduleID = ScheduleID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }



    public void setSlotId(String SlotId) {
        this.slotId = SlotId;
    }

    public String getSlotId() {
        return slotId;
    }



    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int Availability) {
        this.availability =Availability;
    }
}