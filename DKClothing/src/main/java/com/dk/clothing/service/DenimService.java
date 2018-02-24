package com.dk.clothing.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dk.clothing.entities.DenimSizeCdtb;
import com.dk.clothing.entities.Product;

public interface DenimService {
		
	public List<Product> ladiesDenimInTheInventory();
	
	public List<DenimSizeCdtb> getLadiesDenimSizes();
	
	public boolean submitLadiesDenim(MultipartFile[] files, Product products);
}
