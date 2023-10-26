package com.springboot.webapplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("Admin");
        boolean isValidPassword = password.equalsIgnoreCase("Admin@123");

        return isValidUserName &&isValidPassword;
    }
}
