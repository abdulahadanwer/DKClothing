package com.dk.clothing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.ProductsCdtb;

public interface ProductsCdtbRepository extends JpaRepository<ProductsCdtb, String>{
	
	public ProductsCdtb findByProductCd(String productCd);
	
}
