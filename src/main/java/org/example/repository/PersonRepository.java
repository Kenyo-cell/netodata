package org.example.repository;

import org.example.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Query("SELECT p FROM persons p WHERE p.cityOfLiving = :city")
    List<PersonEntity> getAllByCityOfLiving(@Param("city") String city);

    @Query("SELECT p FROM persons p WHERE p.age < :age ORDER BY p.age")
    List<PersonEntity> getAllByAgeBeforeOrderByAgeAsc(@Param("age") int age);

    @Query("SELECT p FROM persons p WHERE p.name = :name AND p.surname = :surname")
    Optional<PersonEntity> getByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}