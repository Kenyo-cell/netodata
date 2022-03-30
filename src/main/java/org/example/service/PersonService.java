package org.example.service;

import org.example.entity.PersonEntity;
import org.springframework.stereotype.Service;
import org.example.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<PersonEntity> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}