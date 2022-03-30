package org.example.repository;

import org.example.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> getAllByCityOfLiving(String city);

    List<PersonEntity> getAllByAgeBeforeOrderByAgeAsc(int age);

    Optional<PersonEntity> getByNameAndSurname(String name, String surname);
}