package com.CarRental.Booking_Car;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookCarDto {

    private int id;

    private LocalDate fromDate;
    private LocalDate toDate;

    private long days;

    private long price;

    private BookingCarStatus status;

    private long userId;

    private long carId;

}
