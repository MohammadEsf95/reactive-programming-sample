package com.example.reactiveprogrammingsample;

import com.example.reactiveprogrammingsample.domain.person.Person;
import com.example.reactiveprogrammingsample.domain.person.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveProgrammingSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingSampleApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PersonRepository repository, DatabaseClient client) {
		return args -> {
			client.sql("create table IF NOT EXISTS person" +
					"(id SERIAL PRIMARY KEY, name varchar (255) not null);").fetch().first().subscribe();
			client.sql("DELETE FROM person;").fetch().first().subscribe();

			Stream<Person> stream = Stream.of(new Person(null, "Mohsen"),
					new Person(null, "Abbas"),
					new Person(null, "Saman"));

			// initialize the database

			repository.saveAll(Flux.fromStream(stream))
					.then()
					.subscribe(); // execute

		};
	}
}
