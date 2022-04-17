package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InvalidAttributeValueException;

@Service
@AllArgsConstructor
public class SecuredPersonService {
    private final PersonRepository repository;

    @Transactional
    public PersonEntity getPersonById(long id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException();
        return repository.getById(id);
    }

    public PersonEntity save(PersonEntity entity) {
        return repository.save(entity);
    }

    public PersonEntity update(PersonEntity entity, long id) {
        if (repository.existsById(id)) entity.setId(id);
        else throw new IllegalArgumentException();
        return repository.save(entity);
    }

    public PersonEntity getByUsername(String username) {
        return repository.getByName(username).orElseThrow(IllegalArgumentException::new);
    }
}
