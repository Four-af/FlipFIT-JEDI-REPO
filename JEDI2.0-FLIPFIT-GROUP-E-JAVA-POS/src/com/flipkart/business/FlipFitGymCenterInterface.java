package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.Slot;

import java.util.Date;
import java.util.List;

public interface FlipFitGymCenterInterface {

    List<FlipFitGymCenter> viewAllGymCenters();
    List<FlipFitGymCenter> getAllCentresByOwmerId(String gymOwnerId);
    List<FlipFitGymCenter> getCentresByCity(String city);
    List<Slot> getAvailableSlotsByCentreAndDate(String centreID, Date date);
    void addCenter(FlipFitGymCenter gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    FlipFitGymCenter getGymCentreById(String centreID);
}