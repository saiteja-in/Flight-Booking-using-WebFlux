package com.saiteja.flightbookingwebflux.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
@Table("passengers")
public class Passenger {

    @Id
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private String gender;

    @Min(0)
    private Integer age;

    @NotBlank
    private String seatNumber;

    @NotBlank
    private String bookingPnr;
}
