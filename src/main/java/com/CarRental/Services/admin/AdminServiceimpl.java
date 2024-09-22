package com.CarRental.Services.admin;

import org.springframework.stereotype.Service;

import com.CarRental.dto.CarDto;
import com.CarRental.entity.Car;
import com.CarRental.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceimpl implements AdminService {

    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) {
        // TODO Auto-generated method stub
        Car car = new Car();
        car.setName(carDto.getName());
        car.setBrand(carDto.getBrand());
        car.setColor(carDto.getColor());
        car.setPrice(carDto.getPrice());
        throw new UnsupportedOperationException("Unimplemented method 'postCar'");
    }





}
