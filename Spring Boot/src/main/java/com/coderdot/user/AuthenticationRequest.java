package com.coderdot.user;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

}
