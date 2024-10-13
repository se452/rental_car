package com.CarRental.Booking_Car;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import com.CarRental.Car.Car;
import com.CarRental.Car.CarDto;
import com.CarRental.user.UserRepository;
import com.CarRental.user.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BookACarReposiotry bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(Car::getCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookCarDto bookCarDto) {
        Optional<Car> optionalCar = carRepository.findById(bookCarDto.getCar_id());
        Optional<User> optionalUser = userRepository.findById(bookCarDto.getUser_id());

        if (optionalCar.isPresent() && optionalUser.isPresent()) {
            Car existingCar = optionalCar.get();
            BookACar bookACar = new BookACar();
            bookACar.setCar(optionalCar.get());
            bookACar.setUser(optionalUser.get());
            bookACar.setBookCarStatus(BookCarStatus.PENDING);

            long diffInMilliSeconds = bookCarDto.getToDate().getTime() - bookCarDto.getFromDate().getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);
            bookACar.setDays(days);
            bookACar.setPrice(existingCar.getPrice() * days);

            bookACarRepository.save(bookACar);

            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return optionalCar.get().getCarDto();
        }
        return null;
    }
}
