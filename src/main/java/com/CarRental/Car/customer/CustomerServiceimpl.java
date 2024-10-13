package com.CarRental.Car.customer;

import org.springframework.stereotype.Service;

import com.CarRental.Car.CarRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomerServiceimpl implements CustomerService{

    private final CarRepository carRepository ;

}
