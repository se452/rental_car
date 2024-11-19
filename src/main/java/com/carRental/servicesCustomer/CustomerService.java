package com.carRental.servicesCustomer;

import com.carRental.bookingcar.BookCarDto;
import com.carRental.car.CarDto;
import com.carRental.car.CarDtoListDto;
import com.carRental.car.SearchCarDto;


import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long carId);

    boolean bookACar(Long carId, BookCarDto bookACarDto);

    List<BookCarDto> getBookingsByUserId(Long userId);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}
