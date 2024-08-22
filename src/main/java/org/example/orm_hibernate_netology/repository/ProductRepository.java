package org.example.orm_hibernate_netology.repository;

import org.example.orm_hibernate_netology.dao.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Order, Long> {
    @Query("SELECT o.productName FROM Order o JOIN Customer c ON o.customer = c WHERE lower(c.name) = lower(:name)")
    List<String> getProductName(@Param("name") String name);
}
