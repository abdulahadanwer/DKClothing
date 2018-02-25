package com.dk.clothing.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dk.clothing.entities.LadiesDenimSizeCdtb;
import com.dk.clothing.entities.Product;

public interface DenimService {
		
	public List<Product> ladiesDenimInTheInventory();
	
	public List<LadiesDenimSizeCdtb> getLadiesDenimSizes();
	
	public boolean submitLadiesDenim(MultipartFile[] files, Product products);
}
