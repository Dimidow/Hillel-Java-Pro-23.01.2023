package org.my.homeworks.repository;

import org.my.homeworks.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudProductRepository extends CrudRepository<Product, Integer> {
}

