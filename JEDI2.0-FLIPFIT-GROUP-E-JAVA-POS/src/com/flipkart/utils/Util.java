package com.flipkart.utils;

import com.flipkart.bean.GymCenter;

import java.util.List;

public class Util {

    public static void printGymCentres(List<GymCenter> centreListByLocation) {
        System.out.println("-----");
        System.out.printf("%-8s\t", "Centre-ID");
        System.out.printf("%-8s\t", "OWNER-ID");
        System.out.printf("%-8s\t", "CENTER-NAME");
        System.out.printf("%8s\t", "GST-IN");
        System.out.printf("%-8s\t", "CITY");
        System.out.printf("%-8s\t", "CAPACITY");
        System.out.printf("%-8s\t", "PRICE");
        System.out.printf("%-8s\t\n", "APPROVED");
        System.out.println("-----");
        for(GymCenter gymCenter: centreListByLocation) {
            System.out.printf("%-8s\t", gymCenter.getGymCenterId());
            System.out.printf("%-8s\t", gymCenter.getOwnerID());
            System.out.printf("%-8s\t",gymCenter.getGymCenterName());
            System.out.printf("%-8s\t", gymCenter.getGstin());
            System.out.printf("%-8s\t", gymCenter.getCity());
            System.out.printf("%-8s\t", gymCenter.getCapacity());
            System.out.printf("%-8s\t", gymCenter.getPrice());
            System.out.printf("%-8s\t\n", gymCenter.isApproved());
        }
        System.out.println("-----");
    }
}
