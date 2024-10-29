package com.carRental.bookingcar.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carRental.car.CarDto;
import com.carRental.bookingcar.BookCarDto;
import com.carRental.bookingcar.CustomerService;

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
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        CarDto carDto = customerService.getCarById(id);
        if (carDto != null) {
            return ResponseEntity.ok(carDto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/car/bookings/{user_id}")
    public ResponseEntity<?> getBookingsByUser_id(@PathVariable Long user_id) {
        List<BookCarDto> bookings = customerService.getBookingsByUser_id(user_id);
        if (bookings != null) {
            return ResponseEntity.ok(bookings);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
