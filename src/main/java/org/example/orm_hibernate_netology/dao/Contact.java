package org.example.orm_hibernate_netology.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {
    private String name;
    private String surname;
    private int age;
}
