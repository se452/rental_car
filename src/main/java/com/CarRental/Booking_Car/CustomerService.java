package com.CarRental.Booking_Car;

import java.util.List;
import com.CarRental.Car.CarDto;

public interface CustomerService {

    List<CarDto> getAllCars();

   
    boolean bookACar(BookCarDto bookCarDto);

    CarDto getCarById(Long id);

}
