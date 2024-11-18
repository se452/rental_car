package com.carRental.payment;


public interface PaymentService {
    
    PaymentResponse processPayment(PaymentRequest paymentRequest);

    boolean refundPayment(String paymentId);
}
