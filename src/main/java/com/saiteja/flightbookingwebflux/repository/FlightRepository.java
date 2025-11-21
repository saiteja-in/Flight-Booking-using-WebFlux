package com.saiteja.flightbookingwebflux.repository;

import com.saiteja.flightbookingwebflux.model.Flight;
import com.saiteja.flightbookingwebflux.model.enums.FlightStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface FlightRepository extends ReactiveCrudRepository<Flight, Long> {

    Flux<Flight> findByStatusOrderByScheduleDateAsc(FlightStatus status);

    Flux<Flight> findByOriginCityIgnoreCaseAndDestinationCityIgnoreCaseAndScheduleDateAndStatusAndAvailableSeatsGreaterThanEqual(
            String originCity,
            String destinationCity,
            LocalDate scheduleDate,
            FlightStatus status,
            int minAvailableSeats);
}
