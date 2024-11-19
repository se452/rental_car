package com.carRental.payment.controller;

import com.carRental.payment.service.PaymentService;
import com.carRental.payment.dto.*;
import com.carRental.payment.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.carRental.payment.dto.ErrorResponse;

@RestController
@RequestMapping("/api/payments")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponse> initiatePayment(@RequestBody @Valid PaymentRequest request) {
        PaymentResponse response = paymentService.initiatePayment(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/confirm")
    public ResponseEntity<PaymentResponse> confirmPayment(
            @RequestParam String paymentIntentId,
            @RequestParam String paymentMethodId,
            @RequestParam Long bookingId) {
        PaymentResponse response = paymentService.confirmPayment(paymentIntentId, paymentMethodId, bookingId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/history/{bookingId}")
    public ResponseEntity<List<PaymentHistoryDTO>> getPaymentHistory(@PathVariable Long bookingId) {
        List<PaymentHistoryDTO> history = paymentService.getPaymentHistory(bookingId);
        return ResponseEntity.ok(history);
    }
    
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookingNotFoundException(BookingNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(InvalidPaymentAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPaymentAmountException(InvalidPaymentAmountException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    // ... other exception handlers remain the same
}
