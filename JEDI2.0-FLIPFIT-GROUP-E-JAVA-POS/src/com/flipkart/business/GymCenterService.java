package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.dao.FlipFitGymCenterDAO;
import java.util.List;

public class GymCenterService implements GymCenterInterface{
    private static FlipFitGymCenterDAO flipFitGymCenterDAO = new FlipFitGymCenterDAO();
    private static ScheduleInterface scheduleService = new ScheduleService();

    public List<GymCenter> viewAllGymCenters() {
        return flipFitGymCenterDAO.viewAllGymCenters();
    }

    public List<GymCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return flipFitGymCenterDAO.getAllCentresByOwmerId(gymOwnerId);
    }

    public List<GymCenter> getCentresByCity(String city){
        return flipFitGymCenterDAO.getGymCentreListByCity(city);
    }

    public List<Slot> getAvailableSlotsByCentreAndDate(String centreID, java.util.Date date) {
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(GymCenter gymCentre) {
        //takes gymCenter details
        flipFitGymCenterDAO.addGymCentre(gymCentre);
    }

    public void requestGymCentreApproval(String gymCentreId){
        flipFitGymCenterDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public GymCenter getGymCentreById(String centreID) {
        GymCenter gymCenter = flipFitGymCenterDAO.getGymCentreByCentreId(centreID);
        return gymCenter;
    }
}
