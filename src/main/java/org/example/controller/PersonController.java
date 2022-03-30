package org.example.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.service.PersonService;

@RestController
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public Object getObject(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }
}