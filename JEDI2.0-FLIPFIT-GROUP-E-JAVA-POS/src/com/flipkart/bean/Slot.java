package com.flipkart.bean;

public class Slot {

    private int id;
    private int gymId;
    private String time;
    private int capacity;

    // Constructor
    public Slot(int id, int gymId, String time, int capacity) {
        this.id = id;
        this.gymId = gymId;
        this.time = time;
        this.capacity = capacity;
    }

    // Getter and Setter methods 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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