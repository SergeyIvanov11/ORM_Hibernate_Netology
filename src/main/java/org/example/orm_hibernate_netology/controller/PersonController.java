package org.example.orm_hibernate_netology.controller;

import jakarta.annotation.security.RolesAllowed;
import org.example.orm_hibernate_netology.dao.Person;
import org.example.orm_hibernate_netology.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured("ROLE_READ")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(service.getPersonsByCity(city));
    }

    @GetMapping("/younger-than")
    @RolesAllowed({ "ROLE_WRITE", "ROLE_DELETE" })
    public ResponseEntity<List<Person>> findByAgeLessThanOrderByAgeAsc(@RequestParam("age") int age) {
        return ResponseEntity.ok(service.findByAgeLessThanOrderByAgeAsc(age));
    }

    @GetMapping("/find-person-by-phone")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public ResponseEntity<Optional<Person>> findByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(service.findByPhoneNumber(phoneNumber));
    }

    @GetMapping("/find-person-by")
    @PreAuthorize("hasRole('ROLE_DELETE')")
    public ResponseEntity<Optional<Person>> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return ResponseEntity.ok(service.findByNameAndSurname(name, surname));
    }

    @GetMapping("/greeting")
    @PreAuthorize("#name == authentication.principal.username")
    public String greetUser(@RequestParam("name") String name) {
        return "Welcome to our app, " + name;
    }
}