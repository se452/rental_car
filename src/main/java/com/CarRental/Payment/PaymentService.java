package com.CarRental.payment;


public interface PaymentService {
    
    PaymentResponse processPayment(PaymentRequest paymentRequest);

    boolean refundPayment(String paymentId);
}
