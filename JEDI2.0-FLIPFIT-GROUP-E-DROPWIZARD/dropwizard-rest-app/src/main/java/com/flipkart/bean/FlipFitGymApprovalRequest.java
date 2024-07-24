package com.flipkart.bean;

public class FlipFitGymApprovalRequest {
    private String id;
    private boolean choice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }

    public FlipFitGymApprovalRequest(String id, boolean choice) {
        this.id = id;
        this.choice = choice;
    }
    public FlipFitGymApprovalRequest(){

    }
}
