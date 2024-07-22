package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class FlipFitAdminDAO implements FlipFitAdminDAOInterface {

    private static FlipFitGymOwnerDAO flipFitGymOwnerDAO = new FlipFitGymOwnerDAO();
    private static FlipFitGymCenterDAO gymCentreDAO = new FlipFitGymCenterDAO();


    public List<GymOwner> getPendingGymOwners() {
        return flipFitGymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, boolean isApproved) {
        flipFitGymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        gymCentreDAO.validateGymCentre(gymCentreId, isApproved);
    }

    public List<GymCenter> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }

}
