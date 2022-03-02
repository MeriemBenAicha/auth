package com.projet.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}