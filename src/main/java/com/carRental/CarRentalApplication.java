package com.carRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.CarRental", "com.CarRental.Booking_Car"})
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }

}
