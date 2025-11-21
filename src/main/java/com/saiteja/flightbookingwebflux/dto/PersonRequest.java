package com.saiteja.flightbookingwebflux.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonRequest {
    @NotBlank
    private String personName;

    @NotBlank
    private String personDream;

    @NotNull
    private LocalDate dob;

}
