package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    public List<FlipFitGymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, boolean isApproved);
    public void validateGymCentre(String gymCentreId, boolean isApproved);
    public List<FlipFitGymCenter> getPendingGymCentres();
}