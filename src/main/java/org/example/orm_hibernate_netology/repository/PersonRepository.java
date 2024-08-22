package org.example.orm_hibernate_netology.repository;

import org.example.orm_hibernate_netology.dao.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE lower(p.cityOfLiving) = lower(:city)")
    List<Person> getPersonsByCity(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
