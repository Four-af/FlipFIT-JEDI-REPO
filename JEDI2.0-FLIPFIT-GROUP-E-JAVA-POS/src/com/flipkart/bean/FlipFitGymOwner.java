package com.flipkart.bean;

import java.util.List;

public class FlipFitGymOwner extends FlipFitUser {
    private String panNumber;
    private List<String> gymCentreIDs;
    private String cardDetails;
    private boolean isApproved;

    public FlipFitGymOwner() {

    }

    public FlipFitGymOwner(String id, String userName, String email, String password, String panNumber, String cardDetails) {
        super(id,userName, email, password, Role.GYM_OWNER);
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = false;
    }

    @Override
    public String getUserID() {
        return super.getUserID();
    }

    public String getPanNumber() {
        return panNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }
}