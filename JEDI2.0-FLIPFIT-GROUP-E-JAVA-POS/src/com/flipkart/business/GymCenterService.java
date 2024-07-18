package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.dao.GymCenterDAO;
import java.util.List;

public class GymCenterService implements GymCenterInterface{
    private static GymCenterDAO gymCenterDAO = new GymCenterDAO();
    private static ScheduleInterface scheduleService = new ScheduleService();

    public List<GymCenter> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCenterDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    public List<GymCenter> getCentresByCity(String city){
        return gymCenterDAO.getGymCentreListByCity(city);
    }

    public List<Slot> getAvailableSlotsByCentreAndDate(String centreID, java.util.Date date) {
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(GymCenter gymCentre) {
        //takes gymCenter details
        gymCenterDAO.addGymCentre(gymCentre);
    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCenterDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public GymCenter getGymCentreById(String centreID) {
        GymCenter gymCenter = gymCenterDAO.getGymCentreByCentreId(centreID);
        return gymCenter;
    }
}
