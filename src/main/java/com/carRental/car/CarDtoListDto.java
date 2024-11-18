package com.carRental.car;
import java.util.List;
import lombok.Data;


@Data
public class CarDtoListDto {
    private List<CarDto> cars;

    public List<CarDto> carDtoList;

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public void setCarDtoList(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }
}
