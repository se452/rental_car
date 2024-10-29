package com.carRental.bookingcar;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.carRental.car.Car;
import com.carRental.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class BookACar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date FromDate;
    private Date ToDate;

    private long days;

    private long price;

    private BookCarStatus bookCarStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;

    public BookCarDto getBookCarDto() {
        BookCarDto bookCarDto = new BookCarDto();
        bookCarDto.setId((long) id);
        bookCarDto.setFromDate(FromDate);
        bookCarDto.setToDate(ToDate);
        bookCarDto.setDays(days);
        bookCarDto.setPrice(price);
        bookCarDto.setStatus(bookCarStatus);
        bookCarDto.setUser_id(user.getId());
        bookCarDto.setCar_id(car.getId());
        bookCarDto.setUsername(user.getName());
        bookCarDto.setEmail(user.getEmail());
        return bookCarDto;

    }
}
