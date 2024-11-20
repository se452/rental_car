package com.coderdot.car.customer;

import com.coderdot.bookingCar.BookACarDto;
import com.coderdot.car.CarDto;
import com.coderdot.car.CarDtoList;
import com.coderdot.car.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long carId);

    boolean bookACar(Long carId, BookACarDto bookACarDto);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoList searchCar(SearchCarDto searchCarDto);

}
