package com.dk.clothing.service;

import java.util.List;

import com.dk.clothing.entities.ProductsCdtb;
import com.dk.clothing.entities.ProductsColorCdtb;

public interface ProductService {
	
	public List<ProductsColorCdtb> findAllProductColors();
	
	public ProductsColorCdtb findByColorCd(String colorCd);
	
	public ProductsColorCdtb saveColorCd(ProductsColorCdtb productsColorCdtb);
	
	public List<ProductsCdtb> findAllProducts();
	
	public ProductsCdtb findByProductCd(String productCd);
	
	public ProductsCdtb saveProduct(ProductsCdtb productsCdtb);
}
