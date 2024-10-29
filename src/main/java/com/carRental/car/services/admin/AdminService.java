package com.carRental.car.services.admin;

import java.io.IOException;
import java.util.List;

import com.carRental.car.CarDto;
import com.carRental.car.CarDtoListDto;
import com.carRental.car.SearchCarDto;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    void deleteCar(Long id);

    CarDto getCarById(Long id);

    boolean updateCar(Long carId , CarDto carDto) throws IOException;
    
    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
