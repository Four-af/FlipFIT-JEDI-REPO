package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public class GymOwnerService implements GymOwnerInterface {
    public void requestGymOwnerApproval(String gymOwnerId) {
    }

    public List<GymOwner> viewAllGymOwners() {
        return List.of();
    }

    public boolean loginGymOwner(String username,String password){
        return true;
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
    }
}