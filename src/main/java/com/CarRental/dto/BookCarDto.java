package com.CarRental.dto;

import com.CarRental.enums.BookCarStatus;

import lombok.Data;
import java.util.Date;

@Data
public class BookCarDto {

  private int id;

  private Date FromDate;
  private Date ToDate;

  private long days;

  private long price;

  private BookCarStatus status;

  private int user_id;

  private int car_id;

}
