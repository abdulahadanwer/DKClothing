package com.dk.clothing.service;

import java.util.List;

import com.dk.clothing.entities.DenimSizeCdtb;
import com.dk.clothing.entities.Product;

public interface DenimService {
		
	public List<Product> ladiesDenimInTheInventory();
	
	public List<DenimSizeCdtb> getLadiesDenimSizes();
	
	public boolean submitLadiesDenim();
}
