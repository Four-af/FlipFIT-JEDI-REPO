package com.flipkart.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.bean.Schedule;

public class ScheduleService implements ScheduleInterface {

    private GymCenterService gymCentreService = new GymCenterService();
    private SlotService slotService = new SlotService();


    public Schedule createSchedule(LocalDate date, String slotId) {
        String centreID = slotService.getSlotByID(slotId).getCenterID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        com.flipkart.bean.Schedule schedule = new com.flipkart.bean.Schedule(date, slotId, availability);

        return schedule; // Return the created schedule
    }

    public Schedule getScheduleByDateAndSlotId(String slotId, LocalDate date) {
        List<com.flipkart.bean.Schedule> scheduleList = new ArrayList<>();

        for (Schedule schedule : scheduleList) {
            if (schedule.getSlotId().equals(slotId) && schedule.getDate().equals(date)) {
                return schedule;
            }
        }
        return null;
    }

    @Override
    public Schedule createSchedule(Date date, String slotId) {
        return null;
    }

    @Override
    public Schedule getScheduleByDateAndSlotId(String slotId, Date date) {
        return null;
    }

    public boolean modifySchedule(String scheduleId, int action) {
        return true;
    }

    @Override
    public List<Schedule> checkAvailability(String centreId, Date date) {
        return List.of();
    }

    @Override
    public List<Slot> getAllAvailableSlotsByDate(String centreId, Date date) {
        return List.of();
    }

    @Override
    public Schedule getOrCreateSchedule(String slotId, Date date) {
        return null;
    }

    public List<Schedule> checkAvailability(String centreID, LocalDate date) {
        List<Slot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        List<Schedule> allAvailableSchedules = new ArrayList<>();
        for (Slot slot : allSlotsForGym) {
            String slotId = slot.getSlotId();
            Schedule schedule = getOrCreateSchedule(slotId, date);
            if (schedule.getAvailability() > 0) {
                allAvailableSchedules.add(schedule);
            }
        }
        return allAvailableSchedules;
    }

    public List<Slot> getAllAvailableSlotsByDate(String centreID, LocalDate date) {
        List<Slot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<Slot> response = new ArrayList<>(allSlotsOfThatCentre); // Start with all slots

        for (Slot slot : allSlotsOfThatCentre) {
            for (Schedule schedule : getAllSchedulesByDate(date)) {
                if (slotService.getSlotByID(schedule.getSlotId()).getCenterID().equals(centreID)) {
                    if (schedule.getAvailability() <= 0) {
                        response.remove(slot); // Remove unavailable slots
                    }
                }
            }
        }
        return response;
    }

    private List<Schedule> getAllSchedulesByDate(LocalDate date) {
        List<Schedule> schedules = new ArrayList<>();

        return schedules;
    }

    public Schedule getOrCreateSchedule(String slotId, LocalDate date) {
        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if (schedule == null) {
            return createSchedule(date, slotId);
        }
        return schedule;
    }


}
