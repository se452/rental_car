package com.coderdot.bookingCar.admin;

import com.coderdot.bookingCar.BookACarDto;
import com.coderdot.car.CarDto;
import com.coderdot.car.CarDtoList;
import com.coderdot.car.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto);

    List<CarDto> getAllCars();

    void deleteCar(Long carId);

    CarDto getCarById(Long cardId);

    boolean updateCar(Long carId,CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarDtoList searchCar(SearchCarDto searchCarDto);

}
