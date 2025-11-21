package com.saiteja.flightbookingwebflux.service;

import com.saiteja.flightbookingwebflux.dto.PersonRequest;
import com.saiteja.flightbookingwebflux.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<Person> createPerson(PersonRequest person);
//    Mono<Person> updatePerson(Long personId,PersonRequest person);
//    Mono<Person> fetchPerson(Long personId);
//    Flux<Person> fetchAllPerson();
//    Flux<Person> searchPersons(String name,String dream);
}
