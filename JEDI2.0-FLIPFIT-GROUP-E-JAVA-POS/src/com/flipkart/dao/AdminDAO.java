package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class AdminDAO implements AdminDAOInterface {

    private static GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private static GymCenterDAO gymCentreDAO = new GymCenterDAO();


    public List<GymOwner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        gymCentreDAO.validateGymCentre(gymCentreId, isApproved);
    }

    public List<GymCenter> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }

}
