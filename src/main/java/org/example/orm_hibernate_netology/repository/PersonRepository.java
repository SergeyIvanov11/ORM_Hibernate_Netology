package org.example.orm_hibernate_netology.repository;

import org.example.orm_hibernate_netology.dao.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE lower(p.city_of_living) = lower(:city)")
    List<Person> getPersonsByCity(@Param("city") String city);
}
