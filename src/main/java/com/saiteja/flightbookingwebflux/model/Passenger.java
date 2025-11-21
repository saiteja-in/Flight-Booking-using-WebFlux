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
    @Column("full_name")
    private String fullName;

    @NotBlank
    @Column("gender")
    private String gender;

    @Min(0)
    @Column("age")
    private Integer age;

    @NotBlank
    @Column("seat_number")
    private String seatNumber;

    @NotBlank
    @Column("booking_pnr")
    private String bookingPnr;
}
