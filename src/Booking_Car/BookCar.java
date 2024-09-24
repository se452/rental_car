package com.CarRental.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BookCar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Date FromDate;
  private Date ToDate;

  private long days;

  private long price;
  
  
}
