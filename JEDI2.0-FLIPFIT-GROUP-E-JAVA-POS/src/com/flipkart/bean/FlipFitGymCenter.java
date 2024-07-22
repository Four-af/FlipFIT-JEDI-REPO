package com.flipkart.bean;

/**
 * Represents a gym in the FlipFit system.
 */
public class FlipFitGymCenter {
    private String gymCenterId;
    private String ownerID;
    private String gymCenterName;
    protected String gstin;
    private String city;
    private int capacity;
    private int price;
    private Boolean isApproved;

    public FlipFitGymCenter() {

    }

    public FlipFitGymCenter(String gymCenterId, String ownerID, String gymCenterName, String gstin, String city, int capacity, int price, Boolean isApproved) {
        this.gymCenterId = gymCenterId;
        this.ownerID = ownerID;
        this.gymCenterName = gymCenterName;
        this.gstin = gstin;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = isApproved;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(String gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGymCenterName() {
        return gymCenterName;
    }

    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public Boolean isApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}