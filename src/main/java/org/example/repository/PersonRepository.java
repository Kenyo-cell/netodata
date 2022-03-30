package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public List<PersonEntity> getPersonsByCity(String city) {
        return entityManager.createNativeQuery(
                "select * from persons p where p.city_of_living = :city",
                PersonEntity.class
                )
                .setParameter("city", city)
                .getResultList();
    }
}