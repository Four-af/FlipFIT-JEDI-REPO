package com.flipkart.dao;

import com.flipkart.bean.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleInterfaceDAO {
    public void addSchedule(Schedule schedule);
    Schedule getSchedule(String scheduleId);
    List<Schedule> getAllScheduleByDate(Date date);
    boolean modifySchedule(String scheduleId,int action);
}