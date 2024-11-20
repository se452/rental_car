package com.carRental.user;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

}
