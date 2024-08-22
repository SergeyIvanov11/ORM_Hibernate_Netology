package org.example.orm_hibernate_netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List getProductName(@Param("name") String name){
        return entityManager.createQuery(
                        "SELECT o.product_name FROM Order o JOIN Customer c ON o.customer = c WHERE lower(c.name) = lower(:name)")
                .setParameter("name", name)
                .getResultList();

    }
}
