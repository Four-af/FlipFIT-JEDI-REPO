package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Role;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerService implements GymOwnerInterface {
    List<GymOwner> allGymOwners = new ArrayList<>();
    public void requestGymOwnerApproval(String gymOwnerId) {
    }

    public List<GymOwner> viewAllGymOwners() {
        return allGymOwners;
    }

    public boolean loginGymOwner(String username,String password){
        return true;
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        allGymOwners.add(new GymOwner(userId, userName, email, password, panNumber, cardNumber));
    }
}