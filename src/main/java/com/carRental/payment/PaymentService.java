package com.CarRental.Payment;


public interface PaymentService {
    
    PaymentResponse processPayment(PaymentRequest paymentRequest);

    boolean refundPayment(String paymentId);
}
