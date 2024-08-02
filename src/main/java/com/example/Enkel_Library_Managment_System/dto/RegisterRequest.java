package com.example.Enkel_Library_Managment_System.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotEmpty(message = "username must not be empty.")
    private String username;

    @NotEmpty(message = "password must not be empty.")
    private String password;

    @NotEmpty(message = "address must not be empty.")
    private String address;
}
