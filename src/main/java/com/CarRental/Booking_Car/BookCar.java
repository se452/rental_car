package com.CarRental.Booking_Car;


import lombok.Data;

import java.util.Date;


@Data
public class BookCar {

  private int id;

  private Date FromDate;
  private Date ToDate;

  private long days;

  private long price;
  
  
}
