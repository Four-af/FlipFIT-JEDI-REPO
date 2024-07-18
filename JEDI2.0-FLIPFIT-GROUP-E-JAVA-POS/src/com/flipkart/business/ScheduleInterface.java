package com.flipkart.business;

import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

import java.util.Date;
import java.util.List;

public interface ScheduleInterface {

    // Create a new schedule for a given date and slot ID
    Schedule createSchedule(Date date, String slotId);

    // Retrieve schedule by slot ID and date
    Schedule getScheduleByDateAndSlotId(String slotId, Date date);

    // Modify schedule based on schedule ID and action
    boolean modifySchedule(String scheduleId, int action);

    // Check availability of schedules for a given center and date
    List<Schedule> checkAvailability(String centreId, Date date);

    // Get all available slots for a given center and date
    List<Slot> getAllAvailableSlotsByDate(String centreId, Date date);

    // Get or create a schedule for a given slot ID and date
    Schedule getOrCreateSchedule(String slotId, Date date);
}
