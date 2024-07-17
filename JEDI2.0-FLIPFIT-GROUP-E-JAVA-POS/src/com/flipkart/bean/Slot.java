package com.flipkart.bean;

public class Slot {

    private String id;
    private int gymId;
    private String time;
    private int capacity;
    private String centerID;
    // Getter and Setter methods 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getSlotId()
    {
        return id;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCenterID() {
        return centerID;
    }

    public void setCenterID(String centerID) {
        this.centerID = centerID;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", gymId=" + gymId +
                ", time='" + time + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}