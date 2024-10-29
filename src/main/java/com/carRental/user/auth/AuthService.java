package com.carRental.user.auth;

import com.carRental.user.SignupRequest;
import com.carRental.user.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
