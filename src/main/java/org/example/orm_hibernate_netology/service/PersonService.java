package org.example.orm_hibernate_netology.service;

import org.example.orm_hibernate_netology.dao.Person;
import org.example.orm_hibernate_netology.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Person> findByAgeLessThanOrderByAgeAsc(int age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}
