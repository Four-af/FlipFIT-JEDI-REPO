package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitAdminDAO;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface {

    FlipFitAdminDAO flipFitAdminDAO = new FlipFitAdminDAO();

    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();

    public void approveGymCenter(String gymCentreId, boolean isApproved){
        flipFitAdminDAO.validateGymCentre(gymCentreId,isApproved);
    }

    public void approveGymOwner(String gymOwnerId, boolean isApproved){
        flipFitAdminDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public List<GymCenter> viewPendingGymCentres(){
        pendinGymCentreList = flipFitAdminDAO.getPendingGymCentres();
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = flipFitAdminDAO.getPendingGymOwners();
        return pendinGymOwnerList;
    }

}
