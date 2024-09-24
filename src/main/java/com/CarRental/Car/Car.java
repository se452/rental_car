package com.CarRental.Car;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cars")


public class Car {

    //addind necessasry elements

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String color;

    private String name;

    private String type;

    private String transmission;

    private String description;

    private Date year;

    private Long price;

    private byte[] image;


    
}
