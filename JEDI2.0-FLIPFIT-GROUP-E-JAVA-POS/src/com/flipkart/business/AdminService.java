package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface{


    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();

    public void approveGymCenter(String gymCentreId,int isApproved){
        System.out.println("Approved/Rejected Gym Center: ");
    }

    public void approveGymOwner(String gymOwnerId,int isApprove){
        //takes GymOwner Object as input and return boolean
        System.out.println("Gym owner approved");
    }

    public List<GymCenter> viewPendingGymCentres(){
        System.out.println("Viewing pending Gym Center Approvals: ");
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");
        return pendinGymOwnerList;
    }

}
