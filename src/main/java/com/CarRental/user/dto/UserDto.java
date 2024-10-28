package com.CarRental.user.dto;

import com.CarRental.user.UserRole;
import lombok.Data;

@Data
public class UserDto {

 private Long id;
 private String name;
 private  String email;
 private UserRole userRole;

}
