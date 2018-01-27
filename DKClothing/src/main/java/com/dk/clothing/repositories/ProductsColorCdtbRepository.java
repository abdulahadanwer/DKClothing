package com.dk.clothing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.ProductsColorCdtb;

public interface ProductsColorCdtbRepository extends JpaRepository<ProductsColorCdtb, String>{
	
	public ProductsColorCdtb findByColorCd(String colorCd);
	
}
