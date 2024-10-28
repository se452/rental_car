package com.CarRental.Payment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")  
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    private String transactionId;  
    private String amount;          
    private String status;          
    
    public Transaction() {}

    public Transaction(String transactionId, String amount, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
