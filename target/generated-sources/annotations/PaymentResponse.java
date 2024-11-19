package com.carRental.payment;

public class PaymentResponse {
    private String status; 
    private String transactionId;  
    public PaymentResponse(String status, String transactionId) {
        this.status = status;
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionId() {
        return transactionId;
    }
}


