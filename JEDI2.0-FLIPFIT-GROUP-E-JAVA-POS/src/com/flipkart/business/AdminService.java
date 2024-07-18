package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface{

    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();
    GymCenterService gymCenterService = new GymCenterService();
    GymOwnerService gymOwnerService = new GymOwnerService();

    public void approveGymCenter(String gymCentreId,int isApproved){
        GymCenter gymCenter = gymCenterService.getGymCentreById(gymCentreId);
        gymCenter.setApproved(true);
        System.out.println("Approved Gym Center: ");
    }

    public void approveGymOwner(String gymOwnerId,int isApprove){
        List<GymOwner> gymOwners = gymOwnerService.allGymOwners;
        for(GymOwner gymOwner: gymOwners) {
            if(gymOwner.getUserID().equals(gymOwnerId)){
                gymOwner.setApproved(true);
                break;
            }
        }
        System.out.println("Gym owner approved");
    }

    public List<GymCenter> viewPendingGymCentres(){
        System.out.println("Viewing pending Gym Center Approvals: ");
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
        return pendinGymOwnerList;
    }

}
