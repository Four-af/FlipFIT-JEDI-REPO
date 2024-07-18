package com.flipkart.dao;

import com.flipkart.bean.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class SlotDAO {

    private Map<String, Slot> slotMap = new HashMap<>();

    public SlotDAO() {
    }

    public List<Slot> getSlotList() {
        return new ArrayList<>(slotMap.values());
    }

    public List<Slot> getSlotByCentreId(String gymCentreId) {
        List<Slot> slotList = new ArrayList<>();
        for (Slot slot : slotMap.values()) {
            if (slot.getCenterID().equals(gymCentreId)) {
                slotList.add(slot);
            }
        }
        return slotList;
    }

    public void addSlot(Slot slot) {
        if (slotMap.containsKey(slot.getSlotId())) {
            throw new RuntimeException("Slot ID already exists");
        }
        slotMap.put(slot.getSlotId(), slot);
        System.out.println("Slot added successfully");
    }

    public Slot getSlotById(String slotID) {
        return slotMap.get(slotID);
    }

    public Slot getSlotByIdandCentreId(String slotID, String centreID) {
        Slot slot = slotMap.get(slotID);
        if (slot != null && slot.getCenterID().equals(centreID)) {
            return slot;
        }
        return null;
    }
}
