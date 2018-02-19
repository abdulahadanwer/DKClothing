package com.dk.clothing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dk.clothing.entities.Product;
import com.dk.clothing.service.DenimService;

@Controller
public class DenimController {
	
	@Autowired
	private DenimService denimService;
	
	@RequestMapping(value="/ladiesDenim", method=RequestMethod.GET)
	public String getDenimInInventory(Model model) {
		model.addAttribute("ladiesDenimList", denimService.denimInTheInventory());
		return "ladiesDenim";
	}
	
	@RequestMapping(value="/addLadiesDenim", method=RequestMethod.GET)
	public String addLadiesDenim(Model model) {
		model.addAttribute("product", new Product());
		return "addLadiesDenim";
	}
	
	@RequestMapping(value="/submitLadiesDenim", method=RequestMethod.POST)
	public String addLadiesDenim(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) { // if there are errors in product form
			//model.addAttribute("productsList", productService.findAllProducts()); //this list does not included the one user tried to enter
	        return "addLadiesDenim";
	    }
		return null;
	}

}
