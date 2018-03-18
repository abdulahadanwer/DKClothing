package com.dk.clothing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dk.clothing.constants.ProductConstants;
import com.dk.clothing.entities.ProductsCdtb;
import com.dk.clothing.entities.ProductsColorCdtb;
import com.dk.clothing.service.ProductService;


@Controller
public class InventoryController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/inventory", method=RequestMethod.GET)
	public String showInventory(Model model) {
		
		return "inventory";
	}

	@RequestMapping(value="/getProductColor", method=RequestMethod.GET)
	public String getProductsColor(Model model) {
		List<ProductsColorCdtb> productsColorList = productService.findAllProductColors();
		
		if(productsColorList != null) 
			model.addAttribute("productsColorList", productsColorList);
					
		model.addAttribute("productColor", new ProductsColorCdtb());
		return "productColor";
	}
	
	@RequestMapping(value="/addProductColor", method=RequestMethod.POST)
	public String addProductColor(@Valid @ModelAttribute("productColor") ProductsColorCdtb productColor, 
									BindingResult bindingResult, 
									Model model,
									RedirectAttributes redirectAttributes) {
		
			
		if (bindingResult.hasErrors()) { // if there are errors in color form
			model.addAttribute("productsColorList", productService.findAllProductColors()); //this list does not included the one user tried to enter
	        return "productColor";
	    }
		if(productService.findByColorCd(productColor.getColorCd().toUpperCase()) == null) { //add only if the color is not available
			productColor.setColorCd(productColor.getColorCd().toUpperCase());
			productColor = productService.saveColorCd(productColor);
			if(productColor != null) 
				redirectAttributes.addFlashAttribute("success", ProductConstants.COLOR_SUCCESS_MSG);
			else
				redirectAttributes.addFlashAttribute("failure", ProductConstants.COLOR_FAILURE_MESSAGE);
		}else
			redirectAttributes.addFlashAttribute("warning", ProductConstants.COLOR_WARNING_MESSAGE);
	
		
		return "redirect:/getProductColor";
	}
	
	@RequestMapping(value="/getProduct", method=RequestMethod.GET)
	public String getProduct(Model model) {
		List<ProductsCdtb> productsList = productService.findAllProducts();
		
		if(productsList != null) 
			model.addAttribute("productsList", productsList);
						
		model.addAttribute("product", new ProductsCdtb());
		return "product";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") ProductsCdtb product, 
								BindingResult bindingResult, 
								Model model,
								RedirectAttributes redirectAttributes) {
		
			
		if (bindingResult.hasErrors()) { // if there are errors in product form
			model.addAttribute("productsList", productService.findAllProducts()); //this list does not included the one user tried to enter
	        return "product";
	    }
		if(productService.findByProductCd(product.getProductCd().toUpperCase()) == null) { //add only if the product is not available
			product.setProductCd(product.getProductCd().toUpperCase());
			product = productService.saveProduct(product);
			if(product != null) 
				redirectAttributes.addFlashAttribute("success", ProductConstants.PRODUCT_SUCCESS_MSG);
			else
				redirectAttributes.addFlashAttribute("failure", ProductConstants.PRODUCT_FAILURE_MESSAGE);
		}else
			redirectAttributes.addFlashAttribute("alreadyExisting", ProductConstants.PRODUCT_EXISTING_MESSAGE);
		
		return "redirect:/getProduct";
	}
	
	@RequestMapping(value="/updateProduct/{productCd}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable String productCd, Model model) {
		
		ProductsCdtb product = productService.findByProductCd(productCd);
		model.addAttribute("product", product);
		switch(productCd) {
		 case ProductConstants.LADIES_DENIM_CD:
			 return "redirect:/ladiesDenim";/*
		 case ProductConstants.RESISTANCE_BELT_CD:
		 	return "redirect:/resistanceBelt";*/
		}
		
		return "undevelopedProduct";
	}
	
}