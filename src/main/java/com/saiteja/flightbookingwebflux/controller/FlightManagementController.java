package com.saiteja.flightbookingwebflux.controller;

import com.saiteja.flightbookingwebflux.dto.FlightRequest;
import com.saiteja.flightbookingwebflux.dto.FlightResponse;
import com.saiteja.flightbookingwebflux.model.Flight;
import com.saiteja.flightbookingwebflux.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightManagementController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public Mono<FlightResponse> createFlight(@Valid @RequestBody FlightRequest request) {
        return flightService.createFlight(request)
                .map(this::toResponse);
    }

    @PutMapping("/{flightId}")
    public Mono<FlightResponse> updateFlight(@PathVariable Long flightId,
                                             @Valid @RequestBody FlightRequest request) {
        return flightService.updateFlight(flightId, request)
                .map(this::toResponse);
    }

    @GetMapping("/{flightId}")
    public Mono<FlightResponse> getFlight(@PathVariable Long flightId) {
        return flightService.fetchFlight(flightId)
                .map(this::toResponse);
    }

    @GetMapping
    public Flux<FlightResponse> listFlights(
            @RequestParam(name = "from", required = false) String originCity,
            @RequestParam(name = "to", required = false) String destinationCity,
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate scheduleDate
    ) {
        if (originCity != null && destinationCity != null && scheduleDate != null) {
            return flightService.searchFlights(originCity, destinationCity, scheduleDate)
                    .map(this::toResponse);
        }

        return flightService.listActiveFlights()
                .map(this::toResponse);
    }

    private FlightResponse toResponse(Flight flight) {
        FlightResponse response = new FlightResponse();
        response.setId(flight.getId());
        response.setFlightNumber(flight.getFlightNumber());
        response.setAirlineName(flight.getAirlineName());
        response.setOriginCity(flight.getOriginCity());
        response.setDestinationCity(flight.getDestinationCity());
        response.setScheduleDate(flight.getScheduleDate());
        response.setDepartureTime(flight.getDepartureTime());
        response.setArrivalTime(flight.getArrivalTime());
        response.setBaseFare(flight.getBaseFare());
        response.setTotalSeats(flight.getTotalSeats());
        response.setAvailableSeats(flight.getAvailableSeats());
        response.setStatus(flight.getStatus());
        response.setCreatedAt(flight.getCreatedAt());
        response.setUpdatedAt(flight.getUpdatedAt());
        return response;
    }

}
