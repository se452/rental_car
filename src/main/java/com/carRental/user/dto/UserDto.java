package com.carRental.user.dto;

import com.carRental.user.UserRole;
import lombok.Data;

@Data
public class UserDto {

 private Long id;
 private String name;
 private  String email;
 private UserRole userRole;

}
