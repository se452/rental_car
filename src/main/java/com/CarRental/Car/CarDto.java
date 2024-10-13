package com.CarRental.Car;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data

public class CarDto {

    private Long id;

    private String brand;

    private String color;

    private String name;

    private String type;

    private String transmission;

    private String description;

    private Date year;

    private Long price;

    private MultipartFile image;


    private byte[] MultipartFile ;
    
}
