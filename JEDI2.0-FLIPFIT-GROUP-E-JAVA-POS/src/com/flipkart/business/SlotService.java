package com.flipkart.business;

import com.flipkart.dao.SlotDAO;
import com.flipkart.bean.Slot;

import java.util.List;

import static java.nio.file.Paths.get;

public class SlotService implements SlotInterface {
    private static final SlotDAO slotDAO = new SlotDAO();
    public List<Slot> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public Slot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    public Slot getSlotByIDCentreId(String slotID,String centreId){
        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
    }

    public List<Slot> getSlotList(){
        return slotDAO.getSlotList();
    }

    public void addSlotsForGym(String gymCentreId, List<Slot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(Slot slot : slotList) {
            slot.setCenterID(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    public boolean isSlotValid(String slotID,String centreId){
        get(slotID, centreId);
        return true;
    }
}