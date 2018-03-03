package com.dk.clothing.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dk.clothing.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.productsCdtb.productCd = 'LD'")
	public List<Product> denimInTheInventory();
}
