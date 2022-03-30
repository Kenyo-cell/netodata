package org.example.controller;

import org.example.entity.PersonEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.service.PersonService;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<PersonEntity> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<PersonEntity> getPersonsByAge(@RequestParam int age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public PersonEntity getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }
}