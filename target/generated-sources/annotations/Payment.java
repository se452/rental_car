package com.carRental.payment;

import lombok.Data;
import java.util.Date;

@Data
public class Payment {


    private Long id;

    private Long amount;

    private String status;

    private Date paymentDate;


}