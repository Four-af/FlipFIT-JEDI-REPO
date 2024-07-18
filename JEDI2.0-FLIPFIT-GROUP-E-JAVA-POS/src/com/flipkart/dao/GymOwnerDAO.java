package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymOwnerDAO {

    private Map<String, GymOwner> gymOwners = new HashMap<>();
    private List<GymOwner> pendingGymOwners = new ArrayList<>();

    public GymOwnerDAO() {}

    public List<GymOwner> getGymOwnerList() {
        return new ArrayList<>(gymOwners.values());
    }

    public void setGymOwnerList(List<GymOwner> gymOwnerList) {
        for (GymOwner owner : gymOwnerList) {
            gymOwners.put(owner.getUserName(), owner);
        }
    }

    public boolean loginGymOwner(String username, String password) {
        GymOwner owner = gymOwners.get(username);
        if (owner != null && owner.getPassword().equals(password)) {
            System.out.println("Login Success");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }

    public void registerGymOwner(GymOwner gymOwner) {
        if (gymOwners.containsKey(gymOwner.getUserName())) {
            System.out.println("Try again with a different Username");
        } else {
            gymOwners.put(gymOwner.getUserName(), gymOwner);
            pendingGymOwners.add(gymOwner);
            System.out.println("Registration Success");
        }
    }

    public List<GymOwner> getPendingGymOwnerList() {
        return new ArrayList<>(pendingGymOwners);
    }

    public void sendOwnerApprovalRequest(String gymOwnerId) {
        GymOwner owner = gymOwners.get(gymOwnerId);
        if (owner != null) {
            owner.setApproved(true);
            System.out.println("Sending gym owner approval request..");
        }
    }

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        GymOwner owner = gymOwners.get(gymOwnerId);
        if (owner != null) {
            owner.setApproved(isApproved);
            if (!isApproved) { // Remove from pending list if approved or disapproved
                pendingGymOwners.remove(owner);
            }
            System.out.println("Gym owner validation updated");
        }
    }
}
