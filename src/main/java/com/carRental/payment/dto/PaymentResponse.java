package com.carRental.payment.dto;

import com.carRental.bookingcar.BookCarDto;

public class PaymentResponse {
    private String paymentId;
    private String status;
    private BookCarDto bookingDetails;

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookCarDto getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookCarDto bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}


