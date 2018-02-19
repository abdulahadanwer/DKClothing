package com.dk.clothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.clothing.entities.Product;
import com.dk.clothing.entities.ProductsCdtb;
import com.dk.clothing.entities.ProductsColorCdtb;
import com.dk.clothing.repositories.ProductRepository;
import com.dk.clothing.repositories.ProductsCdtbRepository;
import com.dk.clothing.repositories.ProductsColorCdtbRepository;
import com.dk.clothing.service.DenimService;
import com.dk.clothing.service.ProductService;

/**
 * @author Khan
 * 
 * */
@Service
public class DenimServiceImpl implements DenimService{
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * @return Product
	 * */
	public List<Product> denimInTheInventory(){
		return productRepository.denimInTheInventory();
	}

}
