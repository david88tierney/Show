package com.codingdojo.templatelogreg.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.templatelogreg.models.Show;
import com.codingdojo.templatelogreg.models.User;
import com.codingdojo.templatelogreg.services.ShowService;

@Controller
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;
    
    public ShowController(ShowService showService) {
        this.showService = showService;
    }
    
    @GetMapping("/add") 
    public String addRoute(@ModelAttribute("show") Show show) {
    	return "add";
    }
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
    	
    	
    	
    	
    	Show exists = showService.findTitle(show.getTitle());
    	if(result.hasErrors())  return "add";
    	if(exists != null) {
    		model.addAttribute("showError", "This title already exists");
    		return "add";
    	} else {
    		showService.createShow(show);
    		return "redirect:/users/dashboard";
    	}
    		
    		
}
    
}
    

