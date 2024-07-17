package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import java.util.HashMap;
import java.util.List;

public interface CustomerInterface{
    public void createCustomer(int userId, String name,String address);
    public void editProfile(int userId, String name, String phoneNumber, String address);
    public void deleteCustomer(int userId, String name);
    public List<GymCenter> viewGyms();
    public HashMap<String, Integer> viewSlots(int gymId, String date);
    public void filterSlots();

}