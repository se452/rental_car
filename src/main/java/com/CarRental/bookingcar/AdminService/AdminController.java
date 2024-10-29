package com.CarRental.bookingcar.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/car/booking/{bookingid}/{status}")
    public ResponseEntity<?> changeBookingStatus(Long bookingid, String status) {
        boolean success = adminService.changeBookingStatus(bookingid, status);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/car/booking/{bookingid}/{status}")
    public ResponseEntity<?> changeBookingStatusPut(Long bookingid, String status) {
        boolean success = adminService.changeBookingStatus(bookingid, status);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    

    

}
