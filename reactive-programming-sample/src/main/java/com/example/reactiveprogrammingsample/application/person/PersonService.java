package com.example.reactiveprogrammingsample.application.person;

import com.example.reactiveprogrammingsample.application.person.dto.CreatePersonDTO;
import com.example.reactiveprogrammingsample.domain.person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Flux<Person> findAll();

    Mono<Person> findById(Long id);

    Mono<Person> save(CreatePersonDTO createPersonDTO);

    Mono<Person> update(Person person);

    Mono<Void> deleteById(Long id);
 }
