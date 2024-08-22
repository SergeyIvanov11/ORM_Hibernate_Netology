package org.example.orm_hibernate_netology.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMERS", schema = "PUBLIC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "surname", length = 30, nullable = false)
    private String surname;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;
}
