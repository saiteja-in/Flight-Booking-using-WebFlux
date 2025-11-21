package com.saiteja.flightbookingwebflux.controller;


import com.saiteja.flightbookingwebflux.dto.PersonRequest;
import com.saiteja.flightbookingwebflux.dto.PersonResponse;
import com.saiteja.flightbookingwebflux.model.Person;
import com.saiteja.flightbookingwebflux.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create")
public class PersonCreationController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public Mono<PersonResponse> createPerson(@Valid @RequestBody PersonRequest request){
        return personService.createPerson(request)
                .map(this::toResponse);

    }
    private PersonResponse toResponse(Person person){
        PersonResponse response = new PersonResponse();
        response.setId(person.getId());
        response.setPersonName(person.getPersonName());
        response.setPersonDream(person.getPersonDream());
        response.setDob(person.getDob());
        response.setCreatedAt(person.getCreatedAt());
        response.setUpdatedAt(person.getUpdatedAt());
        return response;
    }

}
