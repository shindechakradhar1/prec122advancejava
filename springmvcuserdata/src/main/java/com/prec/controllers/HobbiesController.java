package com.prec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prec.entities.Hobby;
import com.prec.services.HobbiesService;

@Controller
@RequestMapping("/hobbies")
public class HobbiesController {

	@Autowired
	private HobbiesService service;
	
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
		String msg=service.addHobbies(hobby);
		return "success";
	}
	
	@GetMapping("/all")
	public String getAllHobbies(Model model) {
		model.addAttribute("hobbiesList", service.fetchAll());
		
		return "hobbies/allhobbies";
	}
	
	@GetMapping("/update/id/{id}")
	public String updateHobbies(@PathVariable int id, Model model) {
		model.addAttribute("hobby", service.fetchHobby(id));
		
		return "hobbies/updatehobbies";
	}
	
	
	@GetMapping("/delete/id/{id}")
	public String deleteHobbies(@PathVariable int id, Model model) {
		model.addAttribute("msg", service.deleteHobbies(id));
		return "success";
	}
	
	
	@PostMapping("/update")
	public String updateHobbiesString(@ModelAttribute Hobby hobby, Model model) {
//		System.out.println(hobby);
		model.addAttribute("msg", service.updateHobbies(hobby));
		return "success";
	}
	
}
