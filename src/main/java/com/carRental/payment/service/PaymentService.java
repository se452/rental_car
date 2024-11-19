package com.carRental.payment.service;

import com.carRental.payment.entity.*;
import com.carRental.payment.repository.*;
import com.carRental.payment.dto.*;
import com.carRental.payment.exception.*;
import com.carRental.bookingcar.*;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;
    
    @Autowired
    private BookACarRepository bookACarRepository;
    
    @Autowired
    private StripeService stripeService;
    
    public PaymentResponse initiatePayment(PaymentRequest request) {
        try {
            // Fetch booking details
            BookACar booking = bookACarRepository.findById(request.getBookingId())
                .orElseThrow(() -> new BookingNotFoundException("Booking not found: " + request.getBookingId()));
            
            // Validate payment amount matches booking price
            if (!request.getAmount().equals(BigDecimal.valueOf(booking.getPrice()))) {
                throw new InvalidPaymentAmountException("Payment amount does not match booking price");
            }
            
            // Create Stripe Payment Intent
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(
                request.getAmount(), 
                request.getCurrency()
            );
            
            // Save payment record
            Payment payment = new Payment();
            payment.setBookACar(booking);
            payment.setAmount(request.getAmount());
            payment.setCurrency(request.getCurrency());
            payment.setStatus("PENDING");
            payment.setStripePaymentId(paymentIntent.getId());
            payment.setPaymentDate(LocalDateTime.now());
            paymentRepository.save(payment);
            
            // Record in payment history
            savePaymentHistory(booking, "INITIATE", request.getAmount(), "PENDING");
            
            // Create response with booking details
            PaymentResponse response = new PaymentResponse();
            response.setPaymentId(paymentIntent.getId());
            response.setStatus("PENDING");
            response.setBookingDetails(booking.getBookCarDto());
            
            return response;
            
        } catch (StripeException e) {
           // log.error("Error initiating payment", e);
            throw new PaymentProcessingException("Failed to initiate payment", e);
        }
    }
    
    public PaymentResponse confirmPayment(String paymentIntentId, String paymentMethodId, Long bookingId) {
        try {
            BookACar booking = bookACarRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found: " + bookingId));
            
            stripeService.attachPaymentMethod(paymentIntentId, paymentMethodId);

            PaymentIntent confirmedPayment = stripeService.confirmPayment(paymentIntentId);
            
            Payment payment = paymentRepository.findByBookACar(booking)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found for booking: " + bookingId));
            
            String status = "COMPLETED";
            if ("succeeded".equals(confirmedPayment.getStatus())) {
                payment.setStatus(status);
                paymentRepository.save(payment);
                
                // Update booking status
                booking.setBookCarStatus(BookCarStatus.APPROVED);
                bookACarRepository.save(booking);
                
                savePaymentHistory(booking, "CONFIRM", payment.getAmount(), status);
                
                PaymentResponse response = new PaymentResponse();
                response.setPaymentId(confirmedPayment.getId());
                response.setStatus(status);
                response.setBookingDetails(booking.getBookCarDto());
                return response;
                
            } else {
                status = "FAILED";
                payment.setStatus(status);
                paymentRepository.save(payment);
                
                savePaymentHistory(booking, "FAILED", payment.getAmount(), status);
                
                throw new PaymentProcessingException("Payment confirmation failed");
            }
            
        } catch (StripeException e) {
            //log.error("Error confirming payment", e);
            throw new PaymentProcessingException("Failed to confirm payment", e);
        }
    }
    
    public List<PaymentHistoryDTO> getPaymentHistory(Long bookingId) {
        BookACar booking = bookACarRepository.findById(bookingId)
            .orElseThrow(() -> new BookingNotFoundException("Booking not found: " + bookingId));
            
        return paymentHistoryRepository.findByBookACarOrderByTimestampDesc(booking)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    private void savePaymentHistory(BookACar booking, String transactionType, 
                                  BigDecimal amount, String status) {
        PaymentHistory history = new PaymentHistory();
        history.setBookACar(booking);
        history.setTransactionType(transactionType);
        history.setAmount(amount);
        history.setStatus(status);
        history.setTimestamp(LocalDateTime.now());
        paymentHistoryRepository.save(history);
    }
    
    private PaymentHistoryDTO convertToDTO(PaymentHistory history) {
        PaymentHistoryDTO dto = new PaymentHistoryDTO();
        dto.setId(history.getId());
        dto.setBookingDetails(history.getBookACar().getBookCarDto());
        dto.setTransactionType(history.getTransactionType());
        dto.setAmount(history.getAmount());
        dto.setStatus(history.getStatus());
        dto.setTimestamp(history.getTimestamp());
        return dto;
    }
}