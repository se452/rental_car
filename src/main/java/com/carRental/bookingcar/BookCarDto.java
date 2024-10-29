package com.carRental.bookingcar;

import java.util.Date;

import lombok.Data;

@Data
public class BookCarDto {

    private Long id;

    private Date FromDate;

    private Date ToDate;

    private long days;

    private long price;

    private BookCarStatus status;

    private Long user_id;

    private Long car_id;

    private String username;

    private String email;

}
