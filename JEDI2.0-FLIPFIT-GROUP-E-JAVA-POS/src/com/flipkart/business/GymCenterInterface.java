package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.Date;
import java.util.List;

public interface GymCenterInterface {

    List<GymCenter> viewAllGymCenters();
    List<GymCenter> getAllCentresByOwmerId(String gymOwnerId);
    List<GymCenter> getCentresByCity(String city);
    List<Slot> getAvailableSlotsByCentreAndDate(String centreID, Date date);
    void addCenter(GymCenter gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    GymCenter getGymCentreById(String centreID);
}