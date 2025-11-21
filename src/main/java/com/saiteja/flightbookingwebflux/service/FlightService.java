package com.saiteja.flightbookingwebflux.service;


import com.saiteja.flightbookingwebflux.dto.FlightRequest;
import com.saiteja.flightbookingwebflux.model.Flight;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface FlightService {

    Mono<Flight> createFlight(FlightRequest request);

    Mono<Flight> updateFlight(Long flightId, FlightRequest request);

    Mono<Flight> fetchFlight(Long flightId);

    Flux<Flight> listActiveFlights();

    Flux<Flight> searchFlights(String originCity, String destinationCity, LocalDate scheduleDate);

    Mono<Void> adjustInventory(Long flightId, int seatsDelta);
}
