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
import com.dk.clothing.service.ProductService;

/**
 * @author Khan
 * 
 * */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductsCdtbRepository productsCdtbRepository;
	
	@Autowired
	private ProductsColorCdtbRepository productColorCdtbRepository;
	
	/**
	 * @return ProductsCdtb
	 * @param colorCd
	 * 
	 * */
	public ProductsColorCdtb findByColorCd(String colorCd){
		return productColorCdtbRepository.findByColorCd(colorCd);
	}

	/**
	 * @return <list>ProductsColorCdtb
	 * */
	public List<ProductsColorCdtb> findAllProductColors() {
		return productColorCdtbRepository.findAll();
	}
	
	/**
	 * @return ProductsColorCdtb
	 * @param productsColorCdtb
	 * */
	public ProductsColorCdtb saveColorCd(ProductsColorCdtb productsColorCdtb) {
		return productColorCdtbRepository.save(productsColorCdtb);
	}

	/**
	 * @return <list>ProductsCdtb
	 * 
	 * */
	public List<ProductsCdtb> findAllProducts(){
		return productsCdtbRepository.findAll();
	}
	
	/**
	 * @return productsCdtb
	 * @param productCd
	 * */
	public ProductsCdtb findByProductCd(String productCd) {
		return productsCdtbRepository.findByProductCd(productCd);
	}
	
	/**
	 * @return ProductsCdtb
	 * @param productsCdtb
	 * */
	public ProductsCdtb saveProduct(ProductsCdtb productsCdtb) {
		return productsCdtbRepository.save(productsCdtb);
	}

}
