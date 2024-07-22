package com.flipkart.dao;

import com.flipkart.bean.FlipFitSchedule;

import java.sql.Date;
import java.util.List;

public interface FlipFitScheduleDAOInterface {
    public void addSchedule(FlipFitSchedule schedule);
    FlipFitSchedule getSchedule(String scheduleId);
    List<FlipFitSchedule> getAllScheduleByDate(Date date);
    boolean modifySchedule(String scheduleId,int action);
}