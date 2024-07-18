package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAO;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface {

    AdminDAO adminDAO  = new AdminDAO();

    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();

    public void approveGymCenter(String gymCentreId, boolean isApproved){
        adminDAO.validateGymCentre(gymCentreId,isApproved);
    }

    public void approveGymOwner(String gymOwnerId, boolean isApproved){
        adminDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public List<GymCenter> viewPendingGymCentres(){
        pendinGymCentreList = adminDAO.getPendingGymCentres();
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = adminDAO.getPendingGymOwners();
        return pendinGymOwnerList;
    }

}
