package com.flipkart.bean;

import java.util.List;

/**
 * Represents a Gym Owner who extends the User class and manages gym centers.
 */
public class GymOwner extends User {

    private String panNumber;            // PAN number of the gym owner
    private List<String> gymCentreIDs;   // List of gym center IDs managed by the owner
    private String cardDetails;          // Card details of the gym owner
    private boolean isApproved;          // Flag indicating whether the gym owner is approved

    /**
     * Default constructor.
     */
    public GymOwner() {
        // Default constructor intentionally left blank
    }

    /**
     * Parameterized constructor to initialize a GymOwner object with user details,
     * PAN number, and card details.
     * @param id User ID of the gym owner
     * @param userName Username of the gym owner
     * @param email Email of the gym owner
     * @param password Password of the gym owner
     * @param panNumber PAN number of the gym owner
     * @param cardDetails Card details of the gym owner
     */
    public GymOwner(String id, String userName, String email, String password,
                    String panNumber, String cardDetails) {
        super(id, userName, email, password, Role.GYM_OWNER);  // Call to superclass constructor
        this.panNumber = panNumber;
        this.cardDetails = cardDetails;
        this.isApproved = false;  // By default, a gym owner is not approved until verified
    }

    /**
     * Retrieves the PAN number of the gym owner.
     * @return The PAN number
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * Sets the PAN number of the gym owner.
     * @param panNumber The PAN number to set
     */
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * Retrieves whether the gym owner is approved or not.
     * @return True if approved, false otherwise
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Sets whether the gym owner is approved or not.
     * @param approved The approval status to set
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * Retrieves the list of gym center IDs managed by the gym owner.
     * @return The list of gym center IDs
     */
    public List<String> getGymCentreIDs() {
        return gymCentreIDs;
    }

    /**
     * Sets the list of gym center IDs managed by the gym owner.
     * @param gymCentreIDs The list of gym center IDs to set
     */
    public void setGymCentreIDs(List<String> gymCentreIDs) {
        this.gymCentreIDs = gymCentreIDs;
    }

    /**
     * Adds a gym center ID to the list of gym center IDs managed by the gym owner.
     * @param gymCentreId The gym center ID to add
     */
    public void addGymCentreId(String gymCentreId) {
        this.gymCentreIDs.add(gymCentreId);
    }

    /**
     * Retrieves the card details of the gym owner.
     * @return The card details
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Sets the card details of the gym owner.
     * @param cardDetails The card details to set
     */
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }
}
