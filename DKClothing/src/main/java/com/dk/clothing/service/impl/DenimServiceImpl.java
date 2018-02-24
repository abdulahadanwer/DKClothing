package com.dk.clothing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.clothing.entities.Denim;
import com.dk.clothing.entities.DenimSizeCdtb;
import com.dk.clothing.entities.Product;
import com.dk.clothing.entities.ProductsCdtb;
import com.dk.clothing.entities.ProductsColorCdtb;
import com.dk.clothing.entities.ProductsImage;
import com.dk.clothing.repositories.DenimSizeCdtbRepository;
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
	
	@Autowired
	private DenimSizeCdtbRepository denimSizeCdtbRepository;
	
	/**
	 * @return Product
	 * */
	public List<Product> ladiesDenimInTheInventory(){
		return productRepository.denimInTheInventory();
	}
	
	/**
	 * @return List<DenimSizeCdtb> 
	 * */
	public List<DenimSizeCdtb> getLadiesDenimSizes(){
		return denimSizeCdtbRepository.findAllByOrderByLadiesDenimSizeCdAsc();
	}
	
	/**
	 * @param files
	 * @param products
	 * @return boolean
	 * */
	public boolean submitLadiesDenim(MultipartFile[] files, Product products) {
		List<ProductsImage> productImageList = new ArrayList<ProductsImage>(); //creating an empty list of images which are submitted  
		Denim[] denims = new Denim[products.getTotalItems()]; //creating a fixed size array for total number of items		
		try {
			for(MultipartFile file : files) { //storing all images in above created list which will later be stored
				ProductsImage productsImage = new ProductsImage();
				productsImage.setImageFileName(file.getOriginalFilename());
				productsImage.setImage(file.getBytes());
				productImageList.add(productsImage);				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

}
