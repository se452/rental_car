package com.CarRental.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.grammars.hql.HqlParser.DateContext;

import com.CarRental.enums.BookCarStatus;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;
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

  private BookCarStatus status;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "car_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;

  private Car car;

}
