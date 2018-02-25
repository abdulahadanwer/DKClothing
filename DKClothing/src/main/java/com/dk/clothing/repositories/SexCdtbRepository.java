package com.dk.clothing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.SexCdtb;

public interface SexCdtbRepository extends JpaRepository<SexCdtb, String>{
	
	public SexCdtb findBySexCd(String sexCd);
	
}
