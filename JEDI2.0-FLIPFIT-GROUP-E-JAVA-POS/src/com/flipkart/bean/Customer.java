package com.flipkart.bean;

/**
 * Represents a Customer entity extending the User class.
 * Contains additional attributes specific to a customer such as phone number and card details.
 */
public class Customer extends User {

    private String customerPhone;    // Phone number of the customer
    private String cardDetails;      // Card details of the customer

    /**
     * Default constructor.
     */
    public Customer() {
        // Default constructor intentionally left blank
    }

    /**
     * Parameterized constructor to initialize a Customer object with user details,
     * customer-specific information such as phone number and card details.
     * @param userId User ID of the customer
     * @param userName Username of the customer
     * @param email Email of the customer
     * @param password Password of the customer
     * @param customerPhone Phone number of the customer
     * @param cardDetails Card details of the customer
     */
    public Customer(String userId, String userName, String email, String password,
                    String customerPhone, String cardDetails) {
        super(userId, userName, email, password, Role.CUSTOMER);  // Call to superclass constructor
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }

    /**
     * Retrieves the phone number of the customer.
     * @return The phone number of the customer
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the phone number of the customer.
     * @param customerPhone The phone number to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Retrieves the card details of the customer.
     * @return The card details of the customer
     */
    public String getCardDetails() {
        return cardDetails;
    }

    /**
     * Sets the card details of the customer.
     * @param cardDetails The card details to set
     */
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

}
