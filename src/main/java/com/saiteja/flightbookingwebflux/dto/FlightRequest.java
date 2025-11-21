package com.saiteja.flightbookingwebflux.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightRequest {

    @NotBlank
    private String flightNumber;

    @NotBlank
    private String airlineName;

    @NotBlank
    private String originCity;

    @NotBlank
    private String destinationCity;

    @NotNull
    @FutureOrPresent
    private LocalDate scheduleDate;

    @NotNull
    private LocalTime departureTime;

    @NotNull
    private LocalTime arrivalTime;

    @NotNull
    @Min(0)
    private Double baseFare;

    @NotNull
    @Min(1)
    private Integer totalSeats;

}


