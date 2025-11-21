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
    @Column("flight_number")
    private String flightNumber;

    @NotBlank
    @Column("airline_name")
    private String airlineName;

    @NotBlank
    @Column("origin_city")
    private String originCity;

    @NotBlank
    @Column("destination_city")
    private String destinationCity;

    @NotNull
    @FutureOrPresent
    @Column("schedule_date")
    private LocalDate scheduleDate;

    @NotNull
    @Column("departure_time")
    private LocalTime departureTime;

    @NotNull
    @Column("arrival_time")
    private LocalTime arrivalTime;

    @NotNull
    @Min(0)
    @Column("base_fare")
    private Double baseFare;

    @NotNull
    @Min(1)
    @Column("total_seats")
    private Integer totalSeats;

    @NotNull
    @Min(0)
    @Column("available_seats")
    private Integer availableSeats;

    @NotNull
    @Column("status")
    private FlightStatus status = FlightStatus.SCHEDULED;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;
}