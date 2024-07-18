package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymCenterDAO {
    private Map<String, GymCenter> gymCentres = new HashMap<>();
    private Map<String, List<GymCenter>> ownerGyms = new HashMap<>();

    public GymCenterDAO() {
    }

    public List<GymCenter> getAllCentresByOwnerId(String gymOwnerId) {
        return ownerGyms.getOrDefault(gymOwnerId, new ArrayList<>());
    }

    public GymCenter getGymCentreByCentreId(String gymCentreId) {
        return gymCentres.get(gymCentreId);
    }

    public void addGymCentre(GymCenter centre) {
        gymCentres.put(centre.getGymCentreID(), centre);
        ownerGyms.computeIfAbsent(centre.getOwnerID(), k -> new ArrayList<>()).add(centre);
    }

    public List<GymCenter> getPendingGymCentreList() {
        List<GymCenter> pendingList = new ArrayList<>();
        for (GymCenter centre : gymCentres.values()) {
            if (!centre.isApproved()) {
                pendingList.add(centre);
            }
        }
        return pendingList;
    }

    public void validateGymCentre(String gymCentreId, boolean isApproved) {
        GymCenter centre = gymCentres.get(gymCentreId);
        if (centre != null) {
            centre.setApproved(isApproved);
        }
    }

    public void sendCentreApprovalRequest(String gymCentreId) {
        GymCenter centre = gymCentres.get(gymCentreId);
        if (centre != null) {
            centre.setApproved(true); // Assuming 2 indicates approval requested
        }
    }

    public List<GymCenter> getGymCentreListByCity(String city) {
        List<GymCenter> allCentreByCity = new ArrayList<>();
        for (GymCenter centre : gymCentres.values()) {
            if (centre.getCity().equalsIgnoreCase(city)) {
                allCentreByCity.add(centre);
            }
        }
        return allCentreByCity;
    }
}
