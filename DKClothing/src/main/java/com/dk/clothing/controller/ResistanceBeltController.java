package com.dk.clothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResistanceBeltController {
	
	@RequestMapping(value="/resistanceBelt", method=RequestMethod.GET)
	public String updateProduct(Model model) {
		return "resistanceBelt";
	}

}
