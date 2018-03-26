package com.dk.clothing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.ProductStatusCdtb;

public interface ProductStatusCdtbRepository extends JpaRepository<ProductStatusCdtb, String>{	
	
	public ProductStatusCdtb findByProductStatusCd(String productStatusCd);
	
}
