package com.saiteja.flightbookingwebflux.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingManagementController {

    @GetMapping("/health")
    public Mono<String> getFlight(){
        return Mono.just("healthy");
    }

}
