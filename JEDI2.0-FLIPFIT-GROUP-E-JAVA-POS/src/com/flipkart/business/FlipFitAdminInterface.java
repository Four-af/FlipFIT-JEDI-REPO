package com.flipkart.business;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * Interface defining operations that an admin can perform in the FlipFit system.
 */
public interface FlipFitAdminInterface {

    /**
     * Approves or rejects a gym center based on the provided ID.
     * @param gymCentreId ID of the gym center to approve/reject
     * @param isApproved True to approve, false to reject
     */
    void approveGymCenter(String gymCentreId, boolean isApproved);

    /**
     * Approves or rejects a gym owner based on the provided ID.
     * @param gymOwnerId ID of the gym owner to approve/reject
     * @param isApproved True to approve, false to reject
     */
    void approveGymOwner(String gymOwnerId, boolean isApproved);

    /**
     * Retrieves a list of pending gym centers awaiting approval.
     * @return List of pending gym centers
     */
    List<FlipFitGymCenter> viewPendingGymCentres();

    /**
     * Retrieves a list of pending gym owners awaiting approval.
     * @return List of pending gym owners
     */
    List<FlipFitGymOwner> viewPendingGymOwners();
}
