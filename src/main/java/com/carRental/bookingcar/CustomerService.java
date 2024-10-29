package com.carRental.bookingcar;

import java.util.List;

import com.carRental.car.CarDto;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookACar(BookCarDto bookCarDto);

    CarDto getCarById(Long id);

    List<BookCarDto> getBookingsByUser_id(Long user_id);

}
