package com.CarRental.Car;
<<<<<<< HEAD

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
=======

import java.util.Date;
>>>>>>> c8b8b084b4274a4ac949778bdc28d467cc13cd75

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(CarDto carDtoname = "cars")
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

    private Date year;

    private Long price;
<<<<<<< HEAD
    
    @Column(columnDefinition = "longblob")
    private MultipartFile image;

    public CarDto getCarDto() {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setPrice(price);
        carDto.setDescription(description);
        carDto.setType(type);
        carDto.setYear(year);
        carDto.setTransmission(transmission);
        carDto.setImage(image);
        return carDto;

=======

    private byte[] image;

    public CarDto getCarDto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarDto'");
>>>>>>> c8b8b084b4274a4ac949778bdc28d467cc13cd75
    }

}
