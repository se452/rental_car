package com.CarRental.Car;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


import java.util.Date;


import jakarta.persistence.Column;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String brand;

    private String color;

    private String name;

    private String type;

    private String transmission;

    private String description;

    private LocalDate manufactureYear;

    private Long price;


    @Column(columnDefinition = "longblob")
//    private MultipartFile image;
    private byte[] image;

    public CarDto getCarDto() {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setPrice(price);
        carDto.setDescription(description);
        carDto.setType(type);
        carDto.setManufactureYear(manufactureYear);
        carDto.setTransmission(transmission);
        carDto.setReturnedImage(image);
        return carDto;


    }
}
