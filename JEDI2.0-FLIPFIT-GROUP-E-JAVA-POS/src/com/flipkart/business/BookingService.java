package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;
import com.flipkart.dao.BookingDAO;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public class BookingService implements BookingInterface {

    private final BookingDAO bookingDAO = new BookingDAO();
    private final ScheduleService scheduleService  = new ScheduleService();
    private final SlotService slotService = new SlotService();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        Slot slot = slotService.getSlotByID(slotId);
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }

    public void addBooking(String userName, String scheduleID) {
        try {
            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
            if(!isAvailable){
                System.out.println("No seats available for the booking");
                return;
            }
            bookingDAO.addBooking(userName, scheduleID);
        } catch (Exception e) {
            System.out.println("Failed to add booking");
        }
    }

    public List<Booking> getBookingByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingByCustomerId(customerId);
        } catch (Exception e) {
            System.out.println("Failed to get booking");
        }
        return null;
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    public void cancelBooking(String bookingID) {
        try {
            Booking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleID(),1);
        } catch (Exception e) {
            System.out.println("Failed to cancel booking");
        }
    }

}
