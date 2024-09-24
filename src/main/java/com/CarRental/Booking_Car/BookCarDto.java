package com.CarRental.Booking_Car;



import lombok.Data;
import java.time.LocalDate;

@Data
public class BookCarDto {

  private int id;

  private LocalDate fromDate;
  private LocalDate toDate;

  private long days;

  private long price;

  private int userId;

  private int carId;
 
}
