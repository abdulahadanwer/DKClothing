package com.dk.clothing.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.DenimSizeCdtb;

public interface DenimSizeCdtbRepository extends JpaRepository<DenimSizeCdtb, String>{	
	
	public List<DenimSizeCdtb> findAllByOrderByLadiesDenimSizeCdAsc();
}
