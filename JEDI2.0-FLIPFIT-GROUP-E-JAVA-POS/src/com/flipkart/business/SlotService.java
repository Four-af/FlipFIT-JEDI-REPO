package com.flipkart.business;

import com.flipkart.dao.FlipFitSlotDAO;
import com.flipkart.bean.Slot;

import java.util.List;

import static java.nio.file.Paths.get;

public class SlotService implements SlotInterface {
    private static final FlipFitSlotDAO FLIP_FIT_SLOT_DAO = new FlipFitSlotDAO();
    public List<Slot> getAllSlotsByCentre(String centreID) {
        return FLIP_FIT_SLOT_DAO.getSlotByCentreId(centreID);
    }

    public Slot getSlotByID(String slotID){
        return FLIP_FIT_SLOT_DAO.getSlotById(slotID);
    }

    public Slot getSlotByIDCentreId(String slotID,String centreId){
        return FLIP_FIT_SLOT_DAO.getSlotByIdandCentreId(slotID,centreId);
    }

    public List<Slot> getSlotList(){
        return FLIP_FIT_SLOT_DAO.getSlotList();
    }

    public void addSlotsForGym(String gymCentreId, List<Slot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(Slot slot : slotList) {
            slot.setCenterID(gymCentreId);
            FLIP_FIT_SLOT_DAO.addSlot(slot);
        }
    }

    public boolean isSlotValid(String slotID,String centreId){
        get(slotID, centreId);
        return true;
    }
}