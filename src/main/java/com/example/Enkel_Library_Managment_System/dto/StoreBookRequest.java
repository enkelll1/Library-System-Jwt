package com.example.Enkel_Library_Managment_System.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.util.Set;

@Data
public class StoreBookRequest {
    @NotEmpty(message = "isbn must not be empty.")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number.")
    private String isbn;

    @NotEmpty(message = "tags must not be empty.")
    private Set<String> tags;
}
