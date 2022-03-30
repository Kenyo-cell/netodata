package org.example.service;

import org.example.entity.PersonEntity;
import org.springframework.stereotype.Service;
import org.example.repository.PersonRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<PersonEntity> getPersonsByCity(String city) {
        return repository.getAllByCityOfLiving(city);
    }

    public List<PersonEntity> getPersonsByAge(@RequestParam int age) {
        return repository.getAllByAgeBeforeOrderByAgeAsc(age);
    }

    public PersonEntity getPersonByNameAndSurname(String name, String surname) {
        return repository.getByNameAndSurname(name, surname).get();
    }
}