package com.prec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
//	@GetMapping("/home")
//	public String getHome() {
//		return "home";
//	}
	
//	@GetMapping("/home")
//	public ModelAndView getHome() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("message", "Message from Home Controller");
//		modelAndView.setViewName("home");
//		return modelAndView;
//	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
//	@GetMapping("/home/name/{name}")
//	public String getHome1(@PathVariable String name,Model model) {
//		model.addAttribute("message", "Another Message from Controller " + name);
//		return "home";
//	}
}
