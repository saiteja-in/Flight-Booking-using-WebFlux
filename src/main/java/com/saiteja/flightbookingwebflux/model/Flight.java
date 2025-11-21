package com.saiteja.flightbookingwebflux.model;

import com.saiteja.flightbookingwebflux.model.enums.FlightStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Table("flights")
public class Flight {

    @Id
    private Long id;

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

    @NotNull
    @Min(0)
    private Integer availableSeats;

    @NotNull
    private FlightStatus status = FlightStatus.SCHEDULED;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}