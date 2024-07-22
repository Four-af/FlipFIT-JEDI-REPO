package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCenter;

import java.util.List;

public interface FlipFitGymCentreDAOInterface {

    List<FlipFitGymCenter> viewAllGymCenters();
    List<FlipFitGymCenter> getAllCentresByOwnerId(String gymOwnerId);
    FlipFitGymCenter getGymCentreByCentreId(String gymCentreId);
    void addGymCentre(FlipFitGymCenter centre);
    public List<FlipFitGymCenter> getPendingGymCentreList();
    public void validateGymCentre(String gymCentreId, boolean isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<FlipFitGymCenter> getGymCentreListByCity(String city);
}