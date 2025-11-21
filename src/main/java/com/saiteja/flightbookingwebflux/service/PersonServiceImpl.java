package com.saiteja.flightbookingwebflux.service;

import com.saiteja.flightbookingwebflux.dto.FlightRequest;
import com.saiteja.flightbookingwebflux.dto.PersonRequest;
import com.saiteja.flightbookingwebflux.model.Flight;
import com.saiteja.flightbookingwebflux.model.Person;
import com.saiteja.flightbookingwebflux.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository repository;

    @Override
    public Mono<Person> createPerson(PersonRequest request){
        Person person = mapRequestToEntity(new Person(),request);
        return repository.save(person);
    }

//    @Override
//    public Mono<Person> updatePerson(Long personId,PersonRequest request){
//
//    }
//
//    @Override
//    public Mono<Person> fetchPerson(Long personId){
//
//    }
//
//    @Override
//    public Flux<Person> fetchAllPerson(){
//
//    }
//
//    @Override
//    public Flux<Person> searchPersons(String name,String dream){
//
//    }

    private Person mapRequestToEntity(Person person, PersonRequest request){
        person.setPersonName(request.getPersonName());
        person.setPersonDream(request.getPersonDream());
        person.setDob(request.getDob());
        return person;

    }

}
