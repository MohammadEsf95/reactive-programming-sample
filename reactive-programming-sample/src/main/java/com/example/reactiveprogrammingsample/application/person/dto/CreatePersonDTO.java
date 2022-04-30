package com.example.reactiveprogrammingsample.application.person.dto;

public class CreatePersonDTO {

    private final String name;

    public CreatePersonDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
