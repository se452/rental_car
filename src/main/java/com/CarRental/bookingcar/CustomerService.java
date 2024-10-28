package com.CarRental.bookingcar;

import java.util.List;

import com.CarRental.Car.CarDto;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookACar(BookCarDto bookCarDto);

    CarDto getCarById(Long id);

    List<BookCarDto> getBookingsByUser_id(Long user_id);

}
