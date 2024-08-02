package com.example.Enkel_Library_Managment_System.controller;

import com.example.Enkel_Library_Managment_System.dto.LoginRequest;
import com.example.Enkel_Library_Managment_System.dto.RegisterRequest;
import com.example.Enkel_Library_Managment_System.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

//    private final AuthService authService;
//
//    @Autowired
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws AuthenticationException {

        return authService.loginUser(loginRequest);
    }
}
