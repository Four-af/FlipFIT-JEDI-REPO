package com.flipkart.dao;

import com.flipkart.bean.Schedule;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDAO {

    private Map<String, Schedule> scheduleMap = new HashMap<>();

    public void addSchedule(Schedule schedule) {
        if (scheduleMap.containsKey(schedule.getScheduleID())) {
            throw new RuntimeException("Schedule ID already exists");
        }
        scheduleMap.put(schedule.getScheduleID(), schedule);
        System.out.println("Schedule added successfully");
    }

    public Schedule getSchedule(String scheduleId) {
        return scheduleMap.get(scheduleId);
    }

    public List<Schedule> getAllScheduleByDate(Date date) {
        List<Schedule> response = new ArrayList<>();
        for (Schedule schedule : scheduleMap.values()) {
            if (schedule.getDate().equals(date)) {
                response.add(schedule);
            }
        }
        return response;
    }

    public boolean modifySchedule(String scheduleId, int action) {
        Schedule schedule = scheduleMap.get(scheduleId);
        if (schedule == null) {
            return false;
        }

        int availability = schedule.getAvailability();
        if (availability < 1 && action == -1) {
            return false;
        }

        schedule.setAvailability(availability + action);
        return true;
    }
}
