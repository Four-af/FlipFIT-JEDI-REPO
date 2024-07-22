package com.flipkart.bean;

/**
 * Represents a payment made for a booking in the Flipkart system.
 */
public class Payment {

    private String paymentId;    // Unique identifier for the payment
    private String amountPaid;   // Amount paid in the payment
    private String bookingId;    // ID of the booking associated with the payment

    /**
     * Retrieves the payment ID.
     * @return The payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment ID.
     * @param paymentId The payment ID to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Retrieves the amount paid in the payment.
     * @return The amount paid
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the amount paid in the payment.
     * @param amountPaid The amount paid to set
     */
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Retrieves the booking ID associated with the payment.
     * @return The booking ID
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking ID associated with the payment.
     * @param bookingId The booking ID to set
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
