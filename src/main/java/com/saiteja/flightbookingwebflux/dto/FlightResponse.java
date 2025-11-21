package com.saiteja.flightbookingwebflux.dto;


import com.saiteja.flightbookingwebflux.model.enums.FlightStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class FlightResponse {

    private Long id;
    private String flightNumber;
    private String airlineName;
    private String originCity;
    private String destinationCity;
    private LocalDate scheduleDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Double baseFare;
    private Integer totalSeats;
    private Integer availableSeats;
    private FlightStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}


