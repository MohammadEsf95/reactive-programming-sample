package com.example.reactiveprogrammingsample.domain.person;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
