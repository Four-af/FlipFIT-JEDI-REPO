package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitAdminInterface {
    void approveGymCenter(String gymCentreId, boolean isApproved);
    void approveGymOwner(String gymOwnerId, boolean isApproved);
    List<FlipFitGymCenter> viewPendingGymCentres();
    List<FlipFitGymOwner> viewPendingGymOwners();
}
