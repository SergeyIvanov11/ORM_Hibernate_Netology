package org.example.orm_hibernate_netology.service;

import org.example.orm_hibernate_netology.dao.Person;
import org.springframework.stereotype.Service;
import org.example.orm_hibernate_netology.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
