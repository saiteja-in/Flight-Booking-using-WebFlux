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
    @Column("pnr")
    private String pnr;

    @NotBlank
    @Column("user_name")
    private String userName;

    @NotBlank
    @Email
    @Column("user_email")
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    @Column("mobile_number")
    private String mobileNumber;

    @CreatedDate
    @Column("booking_date")
    private LocalDateTime bookingDate;

    @NotNull
    @Column("journey_date")
    private LocalDate journeyDate;

    @NotNull
    @Min(1)
    @Column("number_of_seats")
    private Integer numberOfSeats;

    @NotBlank
    @Column("meal_preference")
    private String mealPreference;

    @NotNull
    @Min(0)
    @Column("total_fare")
    private Double totalFare;

    @NotNull
    @Column("booking_status")
    private BookingStatus bookingStatus = BookingStatus.CONFIRMED;

    // Replaces @ManyToOne
    @NotNull
    @Column("flight_id")
    private Long flightId;

    // Replaces @OneToMany (manual fetch)
    // Not persisted — loaded manually in service layer.
    @org.springframework.data.annotation.Transient
    private java.util.List<Passenger> passengers;
}
