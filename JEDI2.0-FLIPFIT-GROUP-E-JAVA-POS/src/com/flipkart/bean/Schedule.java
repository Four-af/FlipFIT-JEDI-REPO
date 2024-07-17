package com.flipkart.bean;

import java.time.LocalDate;
import java.util.UUID;


public class Schedule {
    private String ScheduleID;
    private String SlotId;
    private int Availability;
    private LocalDate date;


    public Schedule(LocalDate date, String SlotId, int Availability) {
        this.ScheduleID=UUID.randomUUID().toString();
        this.date = date;
        this.SlotId = SlotId;
        this.Availability=Availability;
    }


    public void setScheduleID(String ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public String getScheduleID() {
        return ScheduleID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }



    public void setSlotId(String SlotId) {
        this.SlotId = SlotId;
    }

    public String getSlotId() {
        return SlotId;
    }



    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability=Availability;
    }
}