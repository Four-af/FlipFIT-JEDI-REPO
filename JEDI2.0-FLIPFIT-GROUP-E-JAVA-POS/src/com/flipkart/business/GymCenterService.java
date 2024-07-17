package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;

public class GymCenterService implements GymCenterInterface{

    public List<GymCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return List.of();
    }

    public List<GymCenter> getCentresByCity(String city){
        return List.of();
    }

    public List<Slot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return List.of();
    }

    public void addCenter(GymCenter gymCentre) {
        //takes gymCenter details

    }

    public void requestGymCentreApproval(String gymCentreId){
    }

    public GymCenter getGymCentreById(String centreID) {
        GymCenter gymCenter = new GymCenter();
        return gymCenter;
    }
}
