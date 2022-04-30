package com.example.reactiveprogrammingsample.presentation;

import com.example.reactiveprogrammingsample.application.person.PersonService;
import com.example.reactiveprogrammingsample.application.person.dto.CreatePersonDTO;
import com.example.reactiveprogrammingsample.domain.person.Person;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    Flux<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(path = "{id}")
    Mono<Person> findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    Mono<Person> save(@RequestBody CreatePersonDTO createPersonDTO) {
        return personService.save(createPersonDTO);
    }

    @PutMapping
    Mono<Person> update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(path = "{id}")
    Mono<Void> delete(@PathVariable Long id) {
        return personService.deleteById(id);
    }
}
