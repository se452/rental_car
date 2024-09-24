package com.CarRental.Car;
import java.util.Date;


import lombok.Data;

@Data
public class Car {

    //addind necessasry elements
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
