package com.CarRental.Payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
public ResponseEntity<Void> processPayment(@RequestBody PaymentRequest paymentRequest) {
    PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);
    
    
    if ("success".equals(paymentResponse.getStatus())) {
        return new ResponseEntity<>(HttpStatus.OK); 
    } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }
}

    @PostMapping("/refund/{paymentId}")
    public ResponseEntity<Void> refundPayment(@PathVariable String paymentId) {
        boolean success = paymentService.refundPayment(paymentId);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
