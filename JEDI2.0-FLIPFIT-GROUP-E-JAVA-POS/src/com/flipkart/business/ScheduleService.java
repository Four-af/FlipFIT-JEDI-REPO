package com.flipkart.business;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.bean.Schedule;
import com.flipkart.dao.ScheduleDAO;
public class ScheduleService implements ScheduleInterface {

    private final GymCenterService gymCentreService = new GymCenterService();
    private final SlotService slotService = new SlotService();
    private final ScheduleDAO scheduleDAO = new ScheduleDAO();

    public Schedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCenterID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        Schedule schedule = new Schedule(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    public Schedule getScheduleByDateAndSlotId(String SlotId, Date date){
        List<Schedule> scheduleList = scheduleDAO.getAllScheduleByDate((java.sql.Date) date);
        for(Schedule schedule: scheduleList){
            if(schedule.getSlotId().equals(SlotId))
                return schedule;
        }

        return null;
    }

    public boolean modifySchedule(String scheduleId,int action){
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<Schedule> checkAvailability(String centreID, Date date){
        List<Slot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        List<Schedule> allAvailableSchedules = new ArrayList<>();
        for(Slot slot : allSlotsForGym){
            String slotId = slot.getSlotId();
            Schedule schedule = getOrCreateSchedule(slotId, date);
            if(schedule.getAvailability() > 0)
                allAvailableSchedules.add(schedule);
        }

        return allAvailableSchedules;
    }

    public List<Slot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<Slot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<Slot> response = slotService.getAllSlotsByCentre(centreID);
        for(Slot slot: allSlotsOfThatCentre){
            for(Schedule schedule: scheduleDAO.getAllScheduleByDate((java.sql.Date) date)){
                if (slotService.getSlotByID(schedule.getSlotId()).getCenterID().equals(centreID)){
                    if(schedule.getAvailability() <= 0){
                        response.remove(slot);
                    }
                }
            }
        }
        return response;
    }

    public Schedule getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public Schedule getOrCreateSchedule(String slotId, Date date) {
        Schedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }


}
