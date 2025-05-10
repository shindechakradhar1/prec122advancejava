package com.prec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.controllers.entities.Hobby;

@Controller
@RequestMapping("/hobbies")
public class HobbiesController {

	@GetMapping("")
	public String getHobbiesHome() {
		return "hobbies/hobbieshome";
	}
	
	@GetMapping("/new")
	public String addHobbies(Model model) {
		model.addAttribute("hobby", new Hobby());
		return "hobbies/newhobbies";
		
	}
	@PostMapping("/reg")
	public String newHobbies(@ModelAttribute Hobby hobby) {
		System.out.println(hobby);
		return "success";
	}
	
	@GetMapping("/all")
	public String getAllHobbies() {
		return "hobbies/allhobbies";
	}
	
}
