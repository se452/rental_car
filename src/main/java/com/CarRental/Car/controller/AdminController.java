package com.CarRental.controller;

import java.io.IOException;

import com.CarRental.Car.services.admin.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarRental.Car.CarDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/car")

    public ResponseEntity<?> postCar(@ModelAttribute CarDto carDto) throws IOException {
        
        boolean success = adminService.postCar(carDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }

    @GetMapping("/cars")
    

    public ResponseEntity<?> gerAllCars(){
        return ResponseEntity.ok(adminService.getAllCars());

    }


    @DeleteMapping("/car/{id}")

    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        adminService.deleteCar(id);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/car/{id}")

    public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
        CarDto carDto = adminService.getCarById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("car/{carId}")

    public ResponseEntity<Void> updateCar(@PathVariable Long carId, @ModelAttribute CarDto carDto) throws IOException{
        
        try{
        boolean success = adminService.updateCar(carId, carDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
