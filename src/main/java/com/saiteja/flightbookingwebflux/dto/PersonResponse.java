package com.saiteja.flightbookingwebflux.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonResponse {
    private Long id;
    private String personName;
    private String personDream;
    private LocalDate dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
