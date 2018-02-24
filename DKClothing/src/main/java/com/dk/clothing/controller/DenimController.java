package com.dk.clothing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dk.clothing.entities.Product;
import com.dk.clothing.entities.ProductsImage;
import com.dk.clothing.service.DenimService;
import com.dk.clothing.service.ProductService;

@Controller
public class DenimController {
	
	@Autowired
	private DenimService denimService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/ladiesDenim", method=RequestMethod.GET)
	public String getDenimInInventory(Model model) {
		model.addAttribute("ladiesDenimList", denimService.ladiesDenimInTheInventory());
		return "ladiesDenim";
	}
	
	@RequestMapping(value="/addLadiesDenim", method=RequestMethod.GET)
	public String addLadiesDenim(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("productsColorList", productService.findAllProductColors()); 
		model.addAttribute("ladiesDenimSizes", denimService.getLadiesDenimSizes());
		return "addLadiesDenim";
	}
	
	@RequestMapping(value="/submitLadiesDenim", method=RequestMethod.POST)
	public String addLadiesDenim(@RequestParam("file") MultipartFile[] files,
								 @Valid @ModelAttribute("product") Product product, 
								 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) { // if there are errors in product form
	        return "addLadiesDenim";
	    }
		
		List<ProductsImage> productImageList = new ArrayList<ProductsImage>();
		try {
			for(MultipartFile file : files) {
				ProductsImage productsImage = new ProductsImage();
				productsImage.setImageFileName(file.getOriginalFilename());
				productsImage.setImage(file.getBytes());
				productImageList.add(productsImage);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}

}
