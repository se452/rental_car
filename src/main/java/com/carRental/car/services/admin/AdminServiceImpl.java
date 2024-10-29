package com.carRental.car.services.admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.carRental.car.Car;
import com.carRental.car.CarDto;
import com.carRental.car.CarDtoListDto;
import com.carRental.car.CarRepository;
import com.carRental.car.SearchCarDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) throws IOException {

        try {
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setManufactureYear(carDto.getManufactureYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());
            car.setImage(carDto.getImage().getBytes());
            carRepository.save(car);
            return true; 
            
        } catch (Exception e) {
            return false;
        }

        



    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car :: getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
        
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car :: getCarDto).orElse(null);
    }

    @Override
    public boolean updateCar(Long carId, CarDto carDto) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();
            existingCar.setName(carDto.getName());
            existingCar.setBrand(carDto.getBrand());
            existingCar.setColor(carDto.getColor());
            existingCar.setPrice(carDto.getPrice());
            existingCar.setManufactureYear(carDto.getManufactureYear());
            existingCar.setType(carDto.getType());
            existingCar.setDescription(carDto.getDescription());
            existingCar.setTransmission(carDto.getTransmission());
            existingCar.setImage(carDto.getImage().getBytes());
            carRepository.save(existingCar);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setColor(searchCarDto.getColor());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());

        ExampleMatcher exampleMatcher = 
                ExampleMatcher.matchingAll()
                        .withMatcher("brand" , ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("color" , ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type" , ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission" , ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Car> carExample = Example.of(car, exampleMatcher);
        List<Car> carList = carRepository.findAll(carExample);
        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));
        return carDtoListDto;

                        
    }

    


//adminserviceimplnew

    
}
