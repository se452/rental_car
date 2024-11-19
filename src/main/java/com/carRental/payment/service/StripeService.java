package com.carRental.payment.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentUpdateParams;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@Slf4j
public class StripeService {
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;
    
    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }
    
    public PaymentIntent createPaymentIntent(BigDecimal amount, String currency) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount(amount.multiply(new BigDecimal("100")).longValue())
            .setCurrency(currency)
            .build();
            
        return PaymentIntent.create(params);
    }

    public PaymentIntent attachPaymentMethod(String paymentIntentId, String paymentMethodId) throws StripeException {
        if (paymentIntentId == null || paymentMethodId == null) {
            throw new IllegalArgumentException("PaymentIntent ID and Payment Method ID must not be null");
        }

        PaymentIntentUpdateParams updateParams = PaymentIntentUpdateParams.builder()
            .setPaymentMethod(paymentMethodId) // Attach the payment method
            .build();

        return PaymentIntent.retrieve(paymentIntentId).update(updateParams);
    }
    
    public PaymentIntent confirmPayment(String paymentIntentId) throws StripeException {
        PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
        return paymentIntent.confirm();
    }
}