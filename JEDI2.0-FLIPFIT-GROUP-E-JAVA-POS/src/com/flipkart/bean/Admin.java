package com.flipkart.bean;

public class Admin {
    private String adminId;
    private String userId;

    public Admin(String adminId ,String userId) {
        this.adminId = adminId;
        this.userId = userId;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

}