package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {
    public void createAdmin(String adminId, String userId , String userEmail,String userPass);
    public List<GymOwner> viewAllGymOwners();
    public List<GymOwner> viewGymOwnerDetails(String ownerId);
    public List<GymOwner> viewGymOwnerRequests();
    public void approveGymOwnerRequests(String ownerId);
    public void removeGymOwner(String ownerId);
    public void cancelRequest(String ownerId);
}
