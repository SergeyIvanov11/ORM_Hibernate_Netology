package org.example.orm_hibernate_netology.controller;

import org.example.orm_hibernate_netology.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

}
