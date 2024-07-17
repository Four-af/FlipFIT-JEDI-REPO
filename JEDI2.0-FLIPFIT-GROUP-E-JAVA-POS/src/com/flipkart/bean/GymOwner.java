package com.flipkart.bean;

/**
 * Represents a gym owner in the FlipFit system.
 */
public class GymOwner extends User {

    private String ownerId;          // Unique identifier for the gym owner
    private String ownerGstNum;   // GST number of the gym owner
    private String ownerPanNum;   // PAN number of the gym owner
    private String approvalStatus; // Approval status of the gym owner

/**
     * Constructs a FlipFitGymOwner object with the given details.
     *
     * @param ownerId        The unique identifier for the gym owner.
     * @param ownerName      The name of the gym owner.
     * @param ownerPhone     The phone number of the gym owner.
     * @param ownerAddress   The address of the gym owner.
     * @param ownerGstNum    The GST number of the gym owner.
     * @param ownerPanNum    The PAN number of the gym owner.
     * @param approvalStatus The approval status of the gym owner.
     * @param userId         The user identifier associated with the gym owner.
     */

    /**
     * Retrieves the ownerId of the gym owner.
     *
     * @return The ownerId of the gym owner.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the ownerId for the gym owner.
     *
     * @param ownerId The ownerId to set.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Retrieves the ownerGstNum of the gym owner.
     *
     * @return The ownerGstNum of the gym owner.
     */
    public String getOwnerGstNum() {
        return ownerGstNum;
    }

    /**
     * Sets the ownerGstNum for the gym owner.
     *
     * @param ownerGstNum The ownerGstNum to set.
     */
    public void setOwnerGstNum(String ownerGstNum) {
        this.ownerGstNum = ownerGstNum;
    }

    /**
     * Retrieves the ownerPanNum of the gym owner.
     *
     * @return The ownerPanNum of the gym owner.
     */
    public String getOwnerPanNum() {
        return ownerPanNum;
    }

    /**
     * Sets the ownerPanNum for the gym owner.
     *
     * @param ownerPanNum The ownerPanNum to set.
     */
    public void setOwnerPanNum(String ownerPanNum) {
        this.ownerPanNum = ownerPanNum;
    }

    /**
     * Retrieves the approvalStatus of the gym owner.
     *
     * @return The approvalStatus of the gym owner.
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the approvalStatus for the gym owner.
     *
     * @param approvalStatus The approvalStatus to set.
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

}
