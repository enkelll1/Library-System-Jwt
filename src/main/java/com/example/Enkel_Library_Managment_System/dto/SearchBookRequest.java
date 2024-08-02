package com.example.Enkel_Library_Managment_System.dto;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;


@Data
public class SearchBookRequest {
    @NotEmpty(message = "no tags provided.")
    private Set<String> search;
}

