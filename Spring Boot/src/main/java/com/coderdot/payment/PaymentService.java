package com.coderdot.payment;


public interface PaymentService {
    
    PaymentResponse processPayment(PaymentRequest paymentRequest);

    boolean refundPayment(String paymentId);
}
