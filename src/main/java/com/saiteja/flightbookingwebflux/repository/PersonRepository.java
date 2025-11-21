package com.saiteja.flightbookingwebflux.repository;

import com.saiteja.flightbookingwebflux.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person,Long> {

}
