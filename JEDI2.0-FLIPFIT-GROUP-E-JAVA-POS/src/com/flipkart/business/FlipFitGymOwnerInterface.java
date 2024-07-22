package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitGymOwnerInterface {

    void requestGymOwnerApproval(String gymOwnerId);
    List<FlipFitGymOwner> viewAllGymOwners();
    boolean loginGymOwner(String userId, String password);

    void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber);
}