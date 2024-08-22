package org.example.orm_hibernate_netology;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.orm_hibernate_netology.dao.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Person Sergey = Person.builder()
                .name("Sergey")
                .surname("Petrov")
                .age(30)
                .phone_number("89771234567")
                .city_of_living("MOSCOW")
                .build();

        Person Igor = Person.builder()
                .name("Igor")
                .surname("Ivanov")
                .age(25)
                .phone_number("89771234568")
                .city_of_living("ST PETERBURG")
                .build();

        Person Vasya = Person.builder()
                .name("Vasya")
                .surname("Sidorov")
                .age(33)
                .phone_number("89771234569")
                .city_of_living("MOSCOW")
                .build();

        Person Sveta = Person.builder()
                .name("Sveta")
                .surname("Kats")
                .age(28)
                .phone_number("89771234570")
                .city_of_living("PODOLSK")
                .build();

        entityManager.persist(Sergey);
        entityManager.persist(Igor);
        entityManager.persist(Vasya);
        entityManager.persist(Sveta);
    }
}