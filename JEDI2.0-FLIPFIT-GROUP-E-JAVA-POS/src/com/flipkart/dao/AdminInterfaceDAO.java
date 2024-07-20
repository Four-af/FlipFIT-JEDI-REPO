package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterfaceDAO {
    public List<GymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, boolean isApproved);
    public void validateGymCentre(String gymCentreId, boolean isApproved);
    public List<GymCenter> getPendingGymCentres();
}