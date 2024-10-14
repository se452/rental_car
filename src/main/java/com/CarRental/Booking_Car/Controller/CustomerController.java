package com.CarRental.Booking_Car.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRental.Booking_Car.BookCarDto;
import com.CarRental.Booking_Car.CustomerService;
import com.CarRental.Car.CarDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/car/customer")
@RequiredArgsConstructor
public class CustomerController {



    private final CustomerService customerService;

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars() {
        List<CarDto> cars = customerService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/car/book")
    public ResponseEntity<Void> bookACar(@RequestBody BookCarDto bookCarDto) {
        boolean success = customerService.bookACar(bookCarDto);
        if (success) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDto> getCarById(Long id) {
        CarDto carDto = customerService.getCarById(id);
        if (carDto != null) {
            return ResponseEntity.ok(carDto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
