package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {
    void approveGymCenter(String gymCentreId, int isApproved);
    void approveGymOwner(String gymOwnerId,int isApprove);
    List<GymCenter> viewPendingGymCentres();
    List<GymOwner> viewPendingGymOwners();
}
