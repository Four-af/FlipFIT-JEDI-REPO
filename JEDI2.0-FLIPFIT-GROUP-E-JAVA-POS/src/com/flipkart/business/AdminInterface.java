package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {
    void approveGymCenter(String gymCentreId, boolean isApproved);
    void approveGymOwner(String gymOwnerId, boolean isApproved);
    List<GymCenter> viewPendingGymCentres();
    List<GymOwner> viewPendingGymOwners();
}
