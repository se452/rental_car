package com.coderdot.user.auth;

import com.coderdot.user.SignupRequest;
import com.coderdot.user.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
