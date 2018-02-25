package com.dk.clothing.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.clothing.entities.LadiesDenimSizeCdtb;

public interface DenimSizeCdtbRepository extends JpaRepository<LadiesDenimSizeCdtb, Integer>{	
	
	public List<LadiesDenimSizeCdtb> findAllByOrderByLadiesDenimSizeCdAsc();
	
	public LadiesDenimSizeCdtb findByLadiesDenimSizeCd(Integer ladiesDenimSizeCd);
}
