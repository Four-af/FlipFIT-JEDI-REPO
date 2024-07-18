package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.dao.CustomerDAO;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public class CustomerService implements CustomerInterface {

    private GymCenterInterface gymCentreService = new GymCenterService();
    private BookingInterface bookingService = new BookingService();
    private ScheduleInterface scheduleService = new ScheduleService();
    private SlotInterface slotService = new SlotService();
    private CustomerDAO customerDAO = new CustomerDAO();

    public List<GymCenter> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    @Override
    public List<Slot> getAvailableSlots(String centreID, Date date) {
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    public List<Booking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }

    @Override
    public void cancelBookingByID(String bookingID) {
        bookingService.cancelBooking(bookingID);
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingService.getCustomerPlan(customerId);
    }

    public boolean bookSlot(String userName, Date date, String slotId,String centreId){
        if(!slotService.isSlotValid(slotId,centreId)){
            System.out.println("INVALID SLOT");
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId, date).getScheduleID();
        //create booking
        boolean isOverlap = bookingService.checkBookingOverlap(userName,date,slotId);
        if(isOverlap) {
            System.out.println("There exists a conflicting booking, First cancel it!!!!");
            return false;
        }
        bookingService.addBooking(userName, scheduleId);
        return true;
    }



    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        try {
            customerDAO.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Customer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
