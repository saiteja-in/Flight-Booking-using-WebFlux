package com.saiteja.flightbookingwebflux.model;

import com.saiteja.flightbookingwebflux.model.enums.BookingStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table("bookings")
public class Booking {

    @Id
    private String pnr;

    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobileNumber;

    @CreatedDate
    private LocalDateTime bookingDate;

    @NotNull
    private LocalDate journeyDate;

    @NotNull
    @Min(1)
    private Integer numberOfSeats;

    @NotBlank
    private String mealPreference;

    @NotNull
    @Min(0)
    private Double totalFare;

    @NotNull
    private BookingStatus bookingStatus = BookingStatus.CONFIRMED;

    // Replaces @ManyToOne
    @NotNull
    private Long flightId;

    // Replaces @OneToMany (manual fetch)
    // Not persisted — loaded manually in service layer.
    @org.springframework.data.annotation.Transient
    private java.util.List<Passenger> passengers;
}
