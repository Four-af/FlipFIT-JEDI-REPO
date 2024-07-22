package com.flipkart.business;

import com.flipkart.bean.FlipFitSchedule;
import com.flipkart.bean.FlipFitSlot;

import java.util.Date;
import java.util.List;

public interface FlipFitScheduleInterface {

    // Create a new schedule for a given date and slot ID
    FlipFitSchedule createSchedule(Date date, String slotId);

    // Retrieve schedule by slot ID and date
    FlipFitSchedule getScheduleByDateAndSlotId(String slotId, Date date);

    // Modify schedule based on schedule ID and action
    boolean modifySchedule(String scheduleId, int action);

    // Check availability of schedules for a given center and date
    List<FlipFitSchedule> checkAvailability(String centreId, Date date);

    // Get all available slots for a given center and date
    List<FlipFitSlot> getAllAvailableSlotsByDate(String centreId, Date date);

    // Get or create a schedule for a given slot ID and date
    FlipFitSchedule getOrCreateSchedule(String slotId, Date date);
}
