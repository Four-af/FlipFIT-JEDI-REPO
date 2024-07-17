package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {

    public void createAdmin(String adminId,  String emailID, String password);
    public List<GymOwner> viewAllGymOwners();
    public GymOwner viewGymOwnerDetails(String ownerId);
    public GymCenter viewGymCenterDetails(String centerId);
    public GymCenter viewGymOwnerRequests(String ownerID);
    public void approveGymOwnerRequests(String ownerId);
    public void removeGymOwner(String ownerId);
    public void cancelRequest(String ownerId);
}
