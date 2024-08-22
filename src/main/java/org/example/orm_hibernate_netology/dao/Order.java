package org.example.orm_hibernate_netology.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "ORDERS", schema = "PUBLIC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne(optional = false)
    private Customer customer;

    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "product_name", length = 30, nullable = false)
    private String productName;
    @Column(name = "amount", nullable = false)
    private int amount;
}
