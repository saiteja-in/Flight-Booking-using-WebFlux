package com.saiteja.flightbookingwebflux.service;


import com.saiteja.flightbookingwebflux.dto.FlightRequest;
import com.saiteja.flightbookingwebflux.model.Flight;
import com.saiteja.flightbookingwebflux.model.enums.FlightStatus;
import com.saiteja.flightbookingwebflux.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;


    @Override
    public Mono<Flight> createFlight(FlightRequest request) {
        Flight flight = mapRequestToEntity(new Flight(), request);
        flight.setAvailableSeats(request.getTotalSeats());
        flight.setStatus(FlightStatus.SCHEDULED);
        return flightRepository.save(flight);
    }

    @Override
    public Mono<Flight> updateFlight(Long flightId, FlightRequest request) {
        return fetchFlight(flightId)
                .flatMap(existing -> {
                    mapRequestToEntity(existing, request);
                    if (existing.getAvailableSeats() != null && existing.getAvailableSeats() > existing.getTotalSeats()) {
                        existing.setAvailableSeats(existing.getTotalSeats());
                    } else if (existing.getAvailableSeats() == null) {
                        existing.setAvailableSeats(existing.getTotalSeats());
                    }
                    return flightRepository.save(existing);
                });
    }

    @Override
    public Mono<Flight> fetchFlight(Long flightId) {
        return flightRepository.findById(flightId)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight %d not found".formatted(flightId))));
    }

    @Override
    public Flux<Flight> listActiveFlights() {
        return flightRepository.findByStatusOrderByScheduleDateAsc(FlightStatus.SCHEDULED);
    }

    @Override
    public Flux<Flight> searchFlights(String originCity, String destinationCity, LocalDate scheduleDate) {
        return flightRepository.findByOriginCityIgnoreCaseAndDestinationCityIgnoreCaseAndScheduleDateAndStatusAndAvailableSeatsGreaterThanEqual
                (
                originCity,
                destinationCity,
                scheduleDate,
                FlightStatus.SCHEDULED,
                1
        );
    }

    @Override
    public Mono<Void> adjustInventory(Long flightId, int seatsDelta) {
        return fetchFlight(flightId)
                .flatMap(flight -> {
                    Integer current = flight.getAvailableSeats() == null ? 0 : flight.getAvailableSeats();
                    int updatedSeats = current + seatsDelta;
                    if (updatedSeats < 0 || updatedSeats > flight.getTotalSeats()) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat adjustment invalid for flight %d".formatted(flightId)));
                    }
                    flight.setAvailableSeats(updatedSeats);
                    return flightRepository.save(flight).then();
                });
    }

    private Flight mapRequestToEntity(Flight flight, FlightRequest request) {
        flight.setFlightNumber(request.getFlightNumber());
        flight.setAirlineName(request.getAirlineName());
        flight.setOriginCity(request.getOriginCity());
        flight.setDestinationCity(request.getDestinationCity());
        flight.setScheduleDate(request.getScheduleDate());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setBaseFare(request.getBaseFare());
        flight.setTotalSeats(request.getTotalSeats());
        if (flight.getAvailableSeats() == null) {
            flight.setAvailableSeats(request.getTotalSeats());
        }
        return flight;
    }
}
