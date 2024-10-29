package com.CarRental.user.dto;


import com.CarRental.user.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private UserRole userRole;
    private Long userId;




}
