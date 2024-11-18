package com.carRental.payment;

public class PaymentRequest {
    private String amount;
    private String paymentMethod; 
   
    public PaymentRequest(String amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }


    
    public String getAmount() {
        return amount;
    }

    
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
