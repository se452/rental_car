package com.carRental.payment.dto;

import com.carRental.bookingcar.BookCarDto;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentHistoryDTO {
    private Long id;
    private BookCarDto bookingDetails;
    private String transactionType;
    private BigDecimal amount;
    private String status;
    private LocalDateTime timestamp;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookCarDto getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookCarDto bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
