package com.dk.clothing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
