package com.example.reactiveprogrammingsample.application.person;

import com.example.reactiveprogrammingsample.application.person.dto.CreatePersonDTO;
import com.example.reactiveprogrammingsample.domain.person.Person;
import com.example.reactiveprogrammingsample.domain.person.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonDefaultService implements PersonService {

    private final PersonRepository personRepository;

    public PersonDefaultService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Mono<Person> save(CreatePersonDTO createPersonDTO) {
        return personRepository.save(new Person(null, createPersonDTO.getName()));
    }

    @Override
    public Mono<Person> update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return personRepository.deleteById(id);
    }
}
