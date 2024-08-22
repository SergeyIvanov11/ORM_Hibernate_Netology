package org.example.orm_hibernate_netology.controller;

import org.example.orm_hibernate_netology.dao.Person;
import org.example.orm_hibernate_netology.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(service.getPersonsByCity(city));
    }

    @GetMapping("/younger-than")
    public ResponseEntity<List<Person>> findByAgeLessThanOrderByAgeAsc(@RequestParam("age") int age) {
        return ResponseEntity.ok(service.findByAgeLessThanOrderByAgeAsc(age));
    }

    @GetMapping("/find-person-by")
    public ResponseEntity<Optional<Person>> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return ResponseEntity.ok(service.findByNameAndSurname(name, surname));
    }
}
