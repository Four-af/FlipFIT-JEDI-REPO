package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

import java.util.List;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GymCentreInterfaceDAO {

    List<GymCenter> viewAllGymCenters();
    List<GymCenter> getAllCentresByOwnerId(String gymOwnerId);
    GymCenter getGymCentreByCentreId(String gymCentreId);
    void addGymCentre(GymCenter centre);
    public List<GymCenter> getPendingGymCentreList();
    public void validateGymCentre(String gymCentreId, boolean isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<GymCenter> getGymCentreListByCity(String city);
}