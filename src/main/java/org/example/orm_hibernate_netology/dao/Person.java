package org.example.orm_hibernate_netology.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONS", schema = "PUBLIC")
@IdClass(Contact.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "surname")
    private String surname;
    @Id
    @Column(name = "age")
    private int age;
    @Column(name = "phone_number", length = 20)
    private String phone_number;
    @Column(name = "city_of_living", length = 20)
    private String city_of_living;
}
