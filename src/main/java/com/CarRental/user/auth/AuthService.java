package com.CarRental.user.auth;

import com.CarRental.user.SignupRequest;
import com.CarRental.user.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
