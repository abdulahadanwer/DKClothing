package com.dk.clothing.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dk.clothing.constants.ProductConstants;
import com.dk.clothing.entities.LadiesDenim;
import com.dk.clothing.entities.LadiesDenimSizeCdtb;
import com.dk.clothing.entities.Product;
import com.dk.clothing.entities.ProductsImage;
import com.dk.clothing.repositories.DenimSizeCdtbRepository;
import com.dk.clothing.repositories.ProductRepository;
import com.dk.clothing.repositories.ProductsCdtbRepository;
import com.dk.clothing.repositories.SexCdtbRepository;
import com.dk.clothing.service.DenimService;

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
	
	@Autowired
	private SexCdtbRepository sexCdtbRepository;
	
	@Autowired
	private ProductsCdtbRepository productsCdtbRepository;
	
	/**
	 * @return Product
	 * */
	public List<Product> ladiesDenimInTheInventory(){
		return productRepository.denimInTheInventory();
	}
	
	/**
	 * @return List<DenimSizeCdtb> 
	 * */
	public List<LadiesDenimSizeCdtb> getLadiesDenimSizes(){
		return denimSizeCdtbRepository.findAllByOrderByLadiesDenimSizeCdAsc();
	}
	
	/**
	 * @param files
	 * @param products
	 * @return boolean
	 * */
	public boolean submitLadiesDenim(MultipartFile[] files, Product products) {
		List<ProductsImage> productImageList = new ArrayList<ProductsImage>(); //creating an empty list of images which are submitted  
		LadiesDenim[] denims = new LadiesDenim[products.getTotalItems()]; //creating a fixed size array for total number of items		
		try {
			products.setSexCdtb(sexCdtbRepository.findBySexCd(ProductConstants.SEX_CD_FEMALE)); //setting sex code to the product
			products.setProductsCdtb(productsCdtbRepository.findByProductCd(ProductConstants.LADIES_DENIM_CD));
			for(MultipartFile file : files) { //storing all images in above created list which will later be stored
				ProductsImage productsImage = new ProductsImage();
				productsImage.setProduct(products);
				productsImage.setImageFileName(file.getOriginalFilename());
				productsImage.setImage(file.getBytes());
				//adding common elements like created/updated date and created/updated userid
				productsImage.setCretDate(new Date());
				productsImage.setCretUid(ProductConstants.ADMIN);
				productsImage.setUpdtDate(new Date());
				productsImage.setUpdtUid(ProductConstants.ADMIN);
				//////////////////////////
				productImageList.add(productsImage);
			}
			
			LadiesDenimSizeCdtb denimSizeCdtb = denimSizeCdtbRepository.findByLadiesDenimSizeCd(products.getLadiesDenimSizeCd());//denim size for all individual denims
			
			for(int i = 0 ; i < denims.length ; i++) { //setting default values for all individual denims
				denims[i] = new LadiesDenim();
				denims[i].setIsSold(ProductConstants.NO_IND);
				denims[i].setLadiesDenimSizeCdtb(denimSizeCdtb);
				//adding common elements like created/updated date and created/updated userid
				denims[i].setCretDate(new Date());
				denims[i].setCretUid(ProductConstants.ADMIN);
				denims[i].setUpdtDate(new Date());
				denims[i].setUpdtUid(ProductConstants.ADMIN);
				//////////////////////
				denims[i].setProduct(products);
			}
			
			//adding common elements like created/updated date and created/updated userid
			products.setCretDate(new Date());
			products.setCretUid(ProductConstants.ADMIN);
			products.setUpdtDate(new Date());
			products.setUpdtUid(ProductConstants.ADMIN);
			/////////////////////////////////
			
			products.setProductsImages(productImageList);
			
			products.setLadiesDenims(Arrays.asList(denims));	
			
			productRepository.save(products);
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
